package com.example.paths;

import org.openqa.selenium.By;

public enum AdminElement implements SeleniumXpath {

    USER_MANAGEMENT("//a[text()='User Management']");

    private final String xpathSelector;

    AdminElement(String xpathSelector) {
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
