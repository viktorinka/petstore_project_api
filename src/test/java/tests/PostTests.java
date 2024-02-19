package tests;

import data.TestData;
import models.PetBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.Spec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTests {
    TestData testData = new TestData();
    PetBody body = testData.generatedBody();

    @Test
    @DisplayName("Create pet")
    void createPet() {
        PetBody response = step("Make create pet request", () ->
                given()
                        .spec(Spec.requestSpec)
                        .body(body)
                        .when()
                        .post("/pet")
                        .then()
                        .spec(Spec.responseSpec)
                        .body(matchesJsonSchemaInClasspath("petSchema.json"))
                        .extract().as(PetBody.class));
        step("Verify successful create new pet id", () ->
                assertThat(response.getId()).isGreaterThan(0));
        step("Verify successful create new pet with request data", () ->
                assertAll(
                        () -> assertEquals(body.getName(), response.getName()),
                        () -> assertEquals(body.getTags(), response.getTags()),
                        () -> assertEquals(body.getCategory(), response.getCategory()),
                        () -> assertEquals(body.getPhotoUrls(), response.getPhotoUrls()),
                        () -> assertEquals(body.getStatus(), response.getStatus())
                ));
    }
}
