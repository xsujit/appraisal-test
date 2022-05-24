package com.example.pages;

import com.example.paths.SeleniumXpath;
import com.example.utils.WebDriverUtil;

import java.util.Map;

import static com.example.paths.RegisterElement.SUBMIT;
import static com.example.utils.WebDriverUtil.click;
import static com.example.utils.WebDriverUtil.select;

public class RegisterPage {

    public RegisterPage enterDetails(Map<SeleniumXpath, String> data) {
        data.forEach(WebDriverUtil::sendKeys);
        return this;
    }

    public RegisterPage selectProject(SeleniumXpath xpath, String option) {
        select(xpath, option);
        return this;
    }

    public void submit() {
        click(SUBMIT);
    }

}
