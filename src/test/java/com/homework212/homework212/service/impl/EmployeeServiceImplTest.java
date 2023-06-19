package com.homework212.homework212.service.impl;

import com.homework212.homework212.exceptions.EmployeeAlreadyAddedException;
import com.homework212.homework212.exceptions.EmployeeNotFoundException;
import com.homework212.homework212.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    public EmployeeServiceImpl employeeService = new EmployeeServiceImpl();


    @Test
    public void shouldCorrectlyAddEmployee() {
        Employee expected = new Employee("Ivan Petrov", 50000, 1);
        Employee actual = employeeService.addEmployee("Ivan Petrov", 50000, 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyThrowEmployeeAlreadyAddedException() {
        Employee exceptionable = employeeService.addEmployee("Ivan Ivanov", 50000, 1);
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () ->
        {Employee actual = employeeService.addEmployee("Ivan Ivanov", 50000, 1);});
    }

    @Test
    public void shouldCorrectlyRemoveEmployee() {
        Employee removable = employeeService.addEmployee("Ilya Ivanov", 50000, 1);
        String expected = "Ilya Ivanov уволен";
        String actual = employeeService.removeEmployee("Ilya Ivanov");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyFindEmployee() {
        Employee findable = employeeService.addEmployee("Ilya Petrov", 50000, 1);
        Employee expected = findable;
        Employee actual = employeeService.findEmployee("Ilya Petrov");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyThrowEmployeeNotFoundExceptionWhenFinding() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
        {Employee actual = employeeService.findEmployee("Ivan Ivanov");});
    }

    @Test
    public void shouldCorrectlyThrowEmployeeNotFoundExceptionWhenRemoving() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
        {String actual = employeeService.removeEmployee("Ivan Ivanov");});
    }


    @Test
    void shouldCorrectlyDisplayStaff() {
        Employee e1 = employeeService.addEmployee("Ilya Petrov", 50000, 1);
        Employee e2 = employeeService.addEmployee("Ivan Petrov", 50000, 1);
        Employee e3 = employeeService.addEmployee("Ivan Ivanov", 50000, 1);
        Map<String, Employee> expected = new HashMap<>();
        expected.put("Ilya Petrov", e1);
        expected.put("Ivan Petrov", e2);
        expected.put("Ivan Ivanov", e3);
        Map<String, Employee> actual = employeeService.staff();
        Assertions.assertEquals(expected, actual);
    }
}