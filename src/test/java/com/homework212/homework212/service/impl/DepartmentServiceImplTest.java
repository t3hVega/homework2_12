package com.homework212.homework212.service.impl;

import com.homework212.homework212.exceptions.DepartmentNotFound;
import com.homework212.homework212.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final List<Employee> personnel = new ArrayList<>() {{
        add(new Employee("Ivan Petrov", 50000, 1));
        add(new Employee("Ilya Ivanov", 45000, 1));
        add(new Employee("Stas Petrov", 55000, 2));
        add(new Employee("Oleg Ivanov", 65000, 2));
    }};

    @BeforeEach
    public void setUp() {
        Map<String, Employee> staff = new HashMap<>();
        for (Employee employee : personnel) {
            staff.put(employee.getName(), employee);
        }
        when(employeeService.staff()).thenReturn(staff);
    }

    @Test
    public void shouldCorrectlyDisplayDepartmentStaff() {
        Set<Employee> expected = new HashSet<Employee>() {{
                add(new Employee("Stas Petrov", 55000, 2));
                add(new Employee("Oleg Ivanov", 65000, 2));
        }};
        Set<Employee> actual = departmentService.departmentStaff(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyDisplayDepartmentNotFoundExceptionWhenLookingForDepartment() {
        Assertions.assertThrows(DepartmentNotFound.class, () ->
        {Set<Employee> actual = departmentService.departmentStaff(3);});
    }

    @Test
    public void shouldCorrectlyDisplaySumSalaryOfDepartment() {
        Integer expected = 120000;
        Integer actual = departmentService.sumSalary(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyDisplayDepartmentNotFoundExceptionWhenLookingForSumSalaryOfDepartment() {
        Assertions.assertThrows(DepartmentNotFound.class, () ->
        {Integer actual = departmentService.sumSalary(3);});
    }

    @Test
    public void shouldCorrectlyDisplayMaxSalary() {
        Employee expected = new Employee("Oleg Ivanov", 65000, 2);
        Employee actual = departmentService.maxSalary(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyDisplayDepartmentNotFoundExceptionWhenLookingForMaxSalaryOfDepartment() {
        Assertions.assertThrows(DepartmentNotFound.class, () ->
        {Employee actual = departmentService.maxSalary(3);});
    }

    @Test
    public void minSalary() {
        Employee expected = new Employee("Stas Petrov", 55000, 2);
        Employee actual = departmentService.minSalary(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyDisplayDepartmentNotFoundExceptionWhenLookingForMinSalaryOfDepartment() {
        Assertions.assertThrows(DepartmentNotFound.class, () ->
        {Employee actual = departmentService.minSalary(3);});
    }

    @Test
    void shouldCorrectlyDisplayCompanyStaffByDepartments() {
        Map<Integer, List<Employee>> expected = new HashMap<>();
        List<Employee> firstDepartment = new ArrayList<>() {{
            add(new Employee("Ivan Petrov", 50000, 1));
            add(new Employee("Ilya Ivanov", 45000, 1));
        }};
        List<Employee> secondDepartment = new ArrayList<>() {{
            add(new Employee("Stas Petrov", 55000, 2));
            add(new Employee("Oleg Ivanov", 65000, 2));
        }};
        expected.put(1, firstDepartment);
        expected.put(2, secondDepartment);
        Map<Integer, List<Employee>> actual = departmentService.companyStaff();
        Assertions.assertEquals(expected, actual);
    }
}