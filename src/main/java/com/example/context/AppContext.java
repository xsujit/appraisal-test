package com.example.context;

import com.example.paths.SeleniumXpath;
import com.example.utils.DataGenerator;

import java.util.List;
import java.util.Map;

import static com.example.paths.LoginElement.LOGIN_EMAIL;
import static com.example.paths.LoginElement.LOGIN_PASSWORD;

public class AppContext {

    public static final String SHARED_PWD = "password";
    private static final List<Map<SeleniumXpath, String>> employeeData;

    static {
        employeeData = DataGenerator.generateEmployeeData();
    }

    private AppContext() {
    }

    public static List<Map<SeleniumXpath, String>> getEmployeeData() {
        return employeeData;
    }

    public static Map<SeleniumXpath, String> getFacilitator() {
        return Map.of(LOGIN_EMAIL, "stuart.little@mastek.com", LOGIN_PASSWORD, SHARED_PWD);
    }

    public static Map<SeleniumXpath, String> getUser() {
        return Map.of(LOGIN_EMAIL, "james.bond@mastek.com", LOGIN_PASSWORD, SHARED_PWD);
    }

}
