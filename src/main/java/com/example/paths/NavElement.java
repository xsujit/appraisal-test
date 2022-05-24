package com.example.paths;

import org.openqa.selenium.By;

public enum NavElement implements SeleniumXpath {

    REGISTER_LINK("//a[text()='Register']"),
    LOGIN_LINK("//a[text()='Login']"),
    TEAM_LINK("//a[text()='Team']"),
    ADMIN_LINK("//a[text()='Admin']"),
    LOGOUT_LINK("//a[text()='Logout']"),
    HOME_LINK("//a[text()='Home']");

    private final String xpathSelector;

    NavElement(String xpathSelector) {
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
