package com.example.paths;

import org.openqa.selenium.By;

public enum HomeElement implements SeleniumXpath {
    
    BANNER("//h1[@class='display-3']"),
    PROGRESS("//div[contains(@class, 'progress-bar')]"),
    GET_STARTED("//a[contains(text(), 'Get started')]")
    ;

    private final String xpathSelector;

    HomeElement(String xpathSelector) {
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
