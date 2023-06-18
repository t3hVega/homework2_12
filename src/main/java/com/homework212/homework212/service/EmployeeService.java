package com.homework212.homework212.service;

import com.homework212.homework212.model.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String name, Integer salary, Integer id);
    String removeEmployee(String name);
    Employee findEmployee(String name);
    Map<String, Employee> staff();

}
