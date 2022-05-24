package com.example.paths;

import org.openqa.selenium.By;

public enum LoginElement implements SeleniumXpath {

    LOGIN_EMAIL("//input[@id='inputEmail']"),
    LOGIN_PASSWORD("//input[@id='inputPassword']"),
    LOGIN_SUBMIT("//button[@type='submit']");

    private final String xpathSelector;

    LoginElement(String xpathSelector) {
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
