package tests;

import data.TestData;
import models.PetBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.Spec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutTests {
    TestData testData = new TestData();
    PetBody body = testData.generatedBody();

    @Test
    @DisplayName("Update pet")
    void putPet() {
        PetBody response = step("Make update pet", () ->
                given()
                        .spec(Spec.requestSpec)
                        .body(body)
                        .when()
                        .put("/pet")
                        .then()
                        .spec(Spec.responseSpec)
                        .body(matchesJsonSchemaInClasspath("petSchema.json"))
                        .extract().as(PetBody.class));
        step("Verify successful update pet", () ->
                assertAll(
                        () -> assertEquals(body.getName(), response.getName()),
                        () -> assertEquals(body.getTags(), response.getTags()),
                        () -> assertEquals(body.getCategory(), response.getCategory()),
                        () -> assertEquals(body.getPhotoUrls(), response.getPhotoUrls()),
                        () -> assertEquals(body.getStatus(), response.getStatus())
                ));
    }
}

