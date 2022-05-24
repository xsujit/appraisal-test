package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.Navigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static com.example.context.AppContext.getUser;
import static com.example.driver.Browser.quit;
import static org.testng.Assert.assertEquals;

public class LoginTest {

    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    void loginTest() {
        HomePage homePage = new HomePage();
        Navigation navigation = homePage.visit().getNavigationPane();
        navigation.login().enterDetails(getUser()).submit();
        assertEquals(homePage.getProgress(), "25.0%");
        String alert = homePage.getStarted().enterAppraisal().submit().getAlert();
        assertEquals(alert,"Appraisal submitted successfully");
    }

    @AfterClass
    void tearDown() {
        quit();
    }

}
