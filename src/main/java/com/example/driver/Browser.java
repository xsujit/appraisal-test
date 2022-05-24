package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {

    private static final Logger logger = LoggerFactory.getLogger(Browser.class);

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
    }

    private Browser() {}

    private static final ThreadLocal<Browser> INSTANCE = ThreadLocal.withInitial(Browser::new);
    private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = ThreadLocal.withInitial(() -> {
        logger.info("Creating a new driver {}", Thread.currentThread().getId());
        return new ChromeDriver();
    });

    public static WebDriver getDriver() {
        return THREAD_LOCAL_DRIVER.get();
    }

    public static void quit() {
        logger.info("Quitting the browser");
        getDriver().quit();
        THREAD_LOCAL_DRIVER.remove();
    }

}
