package com.example.tests;

import com.example.domain.Employee;
import com.example.pages.HomePage;
import com.example.pages.Navigation;
import com.example.paths.SeleniumXpath;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.example.context.AppContext.getEmployeeData;
import static com.example.context.AppContext.getFacilitator;
import static com.example.driver.Browser.quit;
import static com.example.paths.RegisterElement.PROJECT;
import static com.example.utils.TransformUtils.convertToEmployees;
import static com.example.utils.TransformUtils.convertToObjects;
import static com.example.utils.WebDriverUtil.getCurrentUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;

public class RegisterTest {

    @DataProvider(name = "employees", parallel = true)
    public Object[][] getEmployees() {
        return convertToObjects(getEmployeeData());
    }

    @Test(dataProvider = "employees")
    void registerDataEntryTest(Map<SeleniumXpath, String> employee) {
        HomePage homePage = new HomePage();
        Navigation navigation = homePage.visit().getNavigationPane();
        navigation.register()
                .enterDetails(employee)
                .selectProject(PROJECT, "SLC Onsite")
                .submit();
        assertEquals(getCurrentUrl(), "http://localhost:8080/login");
    }

    @Test(dependsOnMethods = "registerDataEntryTest")
    void registrationTest() {
        HomePage homePage = new HomePage();
        Navigation navigation = homePage.visit().getNavigationPane();
        navigation.login()
                .enterDetails(getFacilitator())
                .submit();
        List<Employee> pendingUsers = navigation.admin().goToUserManagement().getPendingUsers();
        Employee[] testData = convertToEmployees(getEmployeeData());
        assertThat(pendingUsers, hasItems(testData));
    }

    @Test(dependsOnMethods = "registrationTest")
    void approvePendingUsersTest() {
        HomePage homePage = new HomePage();
        Navigation navigation = homePage.visit().getNavigationPane();
        navigation.login()
                .enterDetails(getFacilitator())
                .submit();
        Employee[] testData = convertToEmployees(getEmployeeData());
        List<Employee> approvedUsers = navigation.admin()
                .goToUserManagement()
                .selectUsers(List.of(testData))
                .approveUsers()
                .getApprovedUsers();
        assertThat(approvedUsers, hasItems(testData));
    }

    @AfterMethod
    void tearDown() {
        quit();
    }

}
