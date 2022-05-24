package com.example.pages;

import com.example.paths.SeleniumXpath;

import static com.example.paths.AdminElement.USER_MANAGEMENT;
import static com.example.paths.RegisterElement.SUBMIT;
import static com.example.utils.WebDriverUtil.findElement;
import static com.example.utils.WebDriverUtil.select;

public class AdminPage {

    public ManageUserPage goToUserManagement() {
        findElement(USER_MANAGEMENT).click();
        return new ManageUserPage();
    }

    public AdminPage selectProject(SeleniumXpath xpath, String option) {
        select(xpath, option);
        return this;
    }

    public void submit() {
        findElement(SUBMIT).click();
    }

}
