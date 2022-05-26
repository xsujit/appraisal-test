package com.example.pages;

import com.example.domain.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.paths.ManageUserElement.APPROVED_USERS;
import static com.example.paths.ManageUserElement.APPROVE_USER;
import static com.example.paths.ManageUserElement.PENDING_USERS;
import static com.example.utils.WebDriverUtil.click;
import static com.example.utils.WebDriverUtil.findElement;

public class ManageUserPage {

    public List<Employee> getPendingUsers() {
        WebElement tableBody = findElement(PENDING_USERS);
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<Employee> employees = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            List<String> emp = new ArrayList<>();
            for (WebElement column : columns) {
                emp.add(column.getText());
            }
            employees.add(new Employee(emp.get(1), emp.get(2), emp.get(3), emp.get(4)));
        }
        return employees;
    }

    public ManageUserPage selectUsers(List<Employee> employees) {
        WebElement tableBody = findElement(PENDING_USERS);
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<String> employeeIds = employees.stream()
                .map(Employee::getEmployeeId)
                .collect(Collectors.toList());
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String employeeId = columns.get(1).getText();
            WebElement input = columns.get(5).findElement(By.tagName("input"));
            if (employeeIds.contains(employeeId)) {
                click(input);
            }
        }
        return this;
    }

    public ManageUserPage approveUsers() {
        click(APPROVE_USER);
        return this;
    }

    public List<Employee> getApprovedUsers() {
        WebElement tableBody = findElement(APPROVED_USERS);
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        List<Employee> employees = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            List<String> emp = new ArrayList<>();
            for (WebElement column : columns) {
                emp.add(column.getText());
            }
            employees.add(new Employee(emp.get(1), emp.get(2), emp.get(3), emp.get(4)));
        }
        return employees;
    }

}
