package com.example.utils;

import com.example.paths.SeleniumXpath;
import org.openqa.selenium.By;

import static com.example.utils.WebDriverUtil.findElement;

public class ClickHandler {

    private ClickHandler() {

    }

    public static void click(SeleniumXpath xpath, Object... args) {
        click(xpath.getBy(args));
    }

    public static void click(By by) {
        findElement(by).click();
    }
}
