package com.example.paths;

import org.openqa.selenium.By;

public enum AppraisalElement implements SeleniumXpath {

    APPRAISAL_TEXT("//div[@class='jodit-wysiwyg']"),
    SUBMIT("//button[@type='submit']"),
    ALERT("//div[contains(@class, 'alert')]/child::span")
    ;

    private final String xpathSelector;

    AppraisalElement(String xpathSelector) {
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
