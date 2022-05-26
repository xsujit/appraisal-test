package com.example.utils;

import com.example.paths.SeleniumXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.driver.Browser.getDriver;

public class WebDriverUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverUtil.class);

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
        } else {
            LOGGER.warn("Allowed: input or div. Found: {}", tagName);
        }
    }

    public static void select(SeleniumXpath xpath, String option) {
        Select select = new Select(findElement(xpath));
        select.selectByVisibleText(option);
    }

    public static void click(SeleniumXpath xpath) {
        WebElement element = findElement(xpath.getBy());
        click(element);
    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            LOGGER.info("Click intercepted, trying javascript click");
            LOGGER.debug(e.getMessage());
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        }
    }

    public static String getText(SeleniumXpath xpath) {
        return findElement(xpath.getBy()).getText();
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

}
