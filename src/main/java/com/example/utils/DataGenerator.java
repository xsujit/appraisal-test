package com.example.utils;

import com.example.context.AppContext;
import com.example.paths.SeleniumXpath;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.paths.RegisterElement.EMAIL;
import static com.example.paths.RegisterElement.EMP_ID;
import static com.example.paths.RegisterElement.FIRST_NAME;
import static com.example.paths.RegisterElement.LAST_NAME;
import static com.example.paths.RegisterElement.LOCATION;
import static com.example.paths.RegisterElement.PASSWORD;

public class DataGenerator {

    private DataGenerator() {
    }

    public static List<Map<SeleniumXpath, String>> generateEmployeeData() {
        Faker faker = new Faker();
        List<Map<SeleniumXpath, String>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            list.add(Map.of(FIRST_NAME, firstName,
                    LAST_NAME, lastName,
                    EMAIL, createEmail(firstName, lastName),
                    PASSWORD, AppContext.SHARED_PWD,
                    EMP_ID, String.valueOf(ThreadLocalRandom.current().nextLong(99, 99_999)),
                    LOCATION, faker.address().city()));
        }
        return list;
    }

    private static String createEmail(String firstName, String lastName) {
        return cleanup(firstName) + "." + cleanup(lastName) + "@gmail.com";
    }

    public static String cleanup(String s) {
        return s.replace("'", "").toLowerCase();
    }

    public static String generateParagraph() {
        return new Faker().lorem().paragraph();
    }
}
