package com.example.utils;

import com.example.paths.SeleniumXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.example.driver.Browser.getDriver;

public class WebDriverUtil {

    private WebDriverUtil() {

    }

    public static void goTo(String url) {
        getDriver().navigate().to(url);
    }

    public static WebElement findElement(SeleniumXpath xpath) {
        return findElement(xpath.getBy());
    }

    public static WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public static void sendKeys(SeleniumXpath xpath, CharSequence... keysToSend) {
        WebElement element = findElement(xpath.getBy());
        String tagName = element.getTagName();
        if (tagName.equals("input") || tagName.equals("div")) {
            element.sendKeys(keysToSend);
        }
    }

    public static void select(SeleniumXpath xpath, String option) {
        Select select = new Select(findElement(xpath));
        select.selectByVisibleText(option);
    }

    public static void click(SeleniumXpath xpath) {
        findElement(xpath.getBy()).click();
    }

    public static String getText(SeleniumXpath xpath) {
        return findElement(xpath.getBy()).getText();
    }

}
