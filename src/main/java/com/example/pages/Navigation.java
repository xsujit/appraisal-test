package com.example.pages;

import static com.example.paths.NavElement.ADMIN_LINK;
import static com.example.paths.NavElement.LOGIN_LINK;
import static com.example.paths.NavElement.LOGOUT_LINK;
import static com.example.paths.NavElement.REGISTER_LINK;
import static com.example.utils.WebDriverUtil.findElement;

public class Navigation {

    public RegisterPage register() {
        findElement(REGISTER_LINK).click();
        return new RegisterPage();
    }

    public void logout() {
        findElement(LOGOUT_LINK).click();
    }

    public LoginPage login() {
        findElement(LOGIN_LINK).click();
        return new LoginPage();
    }

    public AdminPage admin() {
        findElement(ADMIN_LINK).click();
        return new AdminPage();
    }

}
