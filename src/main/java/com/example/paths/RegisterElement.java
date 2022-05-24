package com.example.paths;

import org.openqa.selenium.By;

public enum RegisterElement implements SeleniumXpath {

    FIRST_NAME("//input[@id='firstName']"),
    LAST_NAME("//input[@id='lastName']"),
    EMAIL("//input[@id='username']"),
    PASSWORD("//input[@id='password']"),
    EMP_ID("//input[@id='employeeId']"),
    PROJECT("//select[@id='projectId']"),
    LOCATION("//input[@id='location']"),
    SUBMIT("//button[@type='submit']");

    private final String xpathSelector;

    RegisterElement(String xpathSelector) {
        this.xpathSelector = xpathSelector;
    }

    @Override
    public By getBy(Object... args) {
        return By.xpath(String.format(xpathSelector, args));
    }

    @Override
    public String getString(Object... args) {
        return String.format(xpathSelector, args);
    }

}
