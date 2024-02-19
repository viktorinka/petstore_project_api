package tests;

import data.TestData;
import models.DeleteResponse;
import models.PetBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.Spec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteTests {
    TestData testData = new TestData();

    @Test
    @DisplayName("Delete pet")
    void deletePet() {
        PetBody createdPet = step("Make create pet", () ->
                given()
                        .spec(Spec.requestSpec)
                        .body(testData.generatedBody())
                        .when()
                        .post("/pet")
                        .then()
                        .spec(Spec.responseSpec)
                        .body(matchesJsonSchemaInClasspath("petSchema.json"))
                        .extract().as(PetBody.class));

        DeleteResponse deletedPet = step("Make delete pet", () ->
                given()
                        .spec(Spec.requestSpec)
                        .when()
                        .delete("/pet/{id}", createdPet.getId())
                        .then()
                        .spec(Spec.responseSpec)
                        .extract().as(DeleteResponse.class));

        assertAll("Verify deleted pet",
                () -> assertEquals(createdPet.getId().toString(), deletedPet.getMessage())
        );
        DeleteResponse deleteResponse = step("Get pets after deletion", () ->
                given()
                        .spec(Spec.requestSpec)
                        .pathParam("id", createdPet.getId())
                        .when()
                        .get("/pet/{id}")
                        .then()
                        .statusCode(404)
                        .extract().as(DeleteResponse.class));

        assertEquals(testData.errorMessage, deleteResponse.getMessage());
        assertEquals(testData.errorType, deleteResponse.getType());
    }
}
