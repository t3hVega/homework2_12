package com.homework212.homework212.service.impl;

import com.homework212.homework212.exceptions.DepartmentNotFound;
import com.homework212.homework212.model.Employee;
import com.homework212.homework212.service.DepartmentService;
import com.homework212.homework212.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    private final Map<String, Employee> staff = new HashMap<>();

    @Override
    public Set<Employee> departmentStaff(Integer id) {
        if(!companyStaff().containsKey(id) || id == null) {
            throw new DepartmentNotFound("Отдел не найден");
        }
        return employeeService.staff().values().stream()
                .filter(employee -> employee.getId().equals(id))
                .collect(Collectors.toSet());
    }

    @Override
    public Integer sumSalary(Integer id) {
        if(!companyStaff().containsKey(id) || id == null) {
            throw new DepartmentNotFound("Отдел не найден");
        }
        Integer sum = employeeService.staff().values().stream()
                .filter(employee -> id == null || employee.getId().equals(id))
                .mapToInt(Employee::getSalary).sum();
        return sum;
    }

    @Override
    public Employee maxSalary(Integer id) {
        if(!companyStaff().containsKey(id) || id == null) {
            throw new DepartmentNotFound("Отдел не найден");
        }
        return employeeService.staff().values().stream()
                .filter(employee -> employee.getId().equals(id))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee minSalary(Integer id) {
        if(!companyStaff().containsKey(id) || id == null) {
            throw new DepartmentNotFound("Отдел не найден");
        }
        return employeeService.staff().values().stream()
                .filter(employee -> employee.getId().equals(id))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> companyStaff() {
        return employeeService.staff().values().stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }
}
