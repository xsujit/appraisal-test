package com.example.pages;

import com.example.paths.SeleniumXpath;
import com.example.utils.WebDriverUtil;

import java.util.Map;

import static com.example.paths.RegisterElement.SUBMIT;
import static com.example.utils.WebDriverUtil.findElement;

public class LoginPage {

    public LoginPage enterDetails(Map<SeleniumXpath, String> data) {
        data.forEach(WebDriverUtil::sendKeys);
        return this;
    }

    public void submit() {
        findElement(SUBMIT).click();
    }

}
