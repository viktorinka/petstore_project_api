package tests;

import data.TestData;
import models.PetBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spec.Spec;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GetTests {
    TestData testData = new TestData();

    @Test
    @DisplayName("Get pets with pending status")
    void getPetList() {
        List<PetBody> responseList = step("Make get pets with pending status", () ->
                given()
                        .spec(Spec.requestSpec)
                        .when()
                        .get("/pet/findByStatus?status=pending")
                        .then()
                        .spec(Spec.responseSpec)
                        .extract().jsonPath().getList(".", PetBody.class));
        step("Verify pets with pending status",
                () -> assertThat(responseList).extracting("status").containsOnly("pending"));
    }

    @Test
    @DisplayName("Get pet")
    void getPet() {

        PetBody response = step("Make get pet", () ->
                given()
                        .spec(Spec.requestSpec)
                        .when()
                        .get("/pet/" + testData.petId)
                        .then()
                        .spec(Spec.responseSpec)
                        .extract().as(PetBody.class));
        step("Verify pet", () ->
                assertAll(
                        () -> assertEquals(testData.petId, response.getId()),
                        () -> assertEquals("doggie", response.getName()),
                        () -> assertEquals("string", response.getCategory().getName()),
                        () -> assertEquals(0, response.getCategory().getId()),
                        () -> assertNotNull(response.getPhotoUrls()),
                        () -> assertNotNull(response.getStatus())
                ));
    }
}
