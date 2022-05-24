package com.example.utils;

import com.example.domain.Employee;
import com.example.paths.SeleniumXpath;

import java.util.List;
import java.util.Map;

import static com.example.paths.RegisterElement.EMAIL;
import static com.example.paths.RegisterElement.EMP_ID;
import static com.example.paths.RegisterElement.FIRST_NAME;
import static com.example.paths.RegisterElement.LAST_NAME;

public class TransformUtils {

    private TransformUtils() {
    }

    public static Employee[] convertToEmployees(List<Map<SeleniumXpath, String>> employeeData) {
        Employee[] employees = new Employee[employeeData.size()];
        for (Map<SeleniumXpath, String> map : employeeData) {
            Employee employee = new Employee(map.get(EMP_ID), map.get(FIRST_NAME), map.get(LAST_NAME), map.get(EMAIL));
            employees[employeeData.indexOf(map)] = employee;
        }
        return employees;
    }

    public static Object[][] convertToObjects(List<Map<SeleniumXpath, String>> employeeData) {
        Object[][] objects = new Object[employeeData.size()][1];
        for (Map<SeleniumXpath, String> map : employeeData) {
            objects[employeeData.indexOf(map)][0] = map;
        }
        return objects;
    }

}
