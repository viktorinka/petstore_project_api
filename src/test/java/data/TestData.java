package data;

import com.github.javafaker.Faker;
import models.Category;
import models.PetBody;
import models.Tag;

import java.util.List;

public class TestData {
    final Faker faker = new Faker();
    public String photoUrls = "cute_cat.webp";
    public String errorMessage = "Pet not found";
    public String errorType = "error";

    public int petId = 5;

    public PetBody generatedBody() {
        return PetBody.builder()
                .name(faker.name().firstName())
                .category(Category.builder().id(faker.number().randomDigitNotZero()).name(faker.funnyName().name()).build())
                .tags(List.of(Tag.builder().id(faker.number().randomDigitNotZero()).name(faker.funnyName().name()).build()))
                .status(faker.options().option("available", "pending", "sold"))
                .photoUrls(List.of(photoUrls))
                .build();
    }
}