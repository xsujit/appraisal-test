package com.example.utils;

import com.example.context.AppContext;
import com.example.paths.SeleniumXpath;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.paths.RegisterElement.EMAIL;
import static com.example.paths.RegisterElement.EMP_ID;
import static com.example.paths.RegisterElement.FIRST_NAME;
import static com.example.paths.RegisterElement.LAST_NAME;
import static com.example.paths.RegisterElement.LOCATION;
import static com.example.paths.RegisterElement.PASSWORD;

public class DataGenerator {

    private static final Faker faker = new Faker();

    private DataGenerator() {
    }

    public static List<Map<SeleniumXpath, String>> generateEmployeeData() {
        List<Map<SeleniumXpath, String>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Name name = faker.name();
            list.add(Map.of(FIRST_NAME, name.firstName(),
                    LAST_NAME, name.lastName(),
                    EMAIL, name.username() + "@gmail.com",
                    PASSWORD, AppContext.SHARED_PWD,
                    EMP_ID, String.valueOf(faker.number().randomNumber(5, false)),
                    LOCATION, faker.address().city()));
        }
        return list;
    }

    public static String generateParagraph() {
        return faker.lorem().paragraph();
    }
}
