package com.example.paths;

import org.openqa.selenium.By;

public enum ManageUserElement implements SeleniumXpath {

    PENDING_USERS("//h3[text()='Pending approval']/parent::div/descendant::tbody"),
    APPROVED_USERS("//h3[text()='Approved Users']/parent::div/descendant::tbody"),
    APPROVE_USER("//button[text()='Approve Users']")
    ;

    private final String xpathSelector;

    ManageUserElement(String xpathSelector) {
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
