package com.example.paths;

import org.openqa.selenium.By;

public interface SeleniumXpath {

    By getBy(Object... args);

    String getString(Object... args);

}
