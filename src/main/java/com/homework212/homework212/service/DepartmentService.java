package com.homework212.homework212.service;

import com.homework212.homework212.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface DepartmentService {
    Set<Employee> departmentStaff(Integer id);
    Integer sumSalary(Integer id);
    Employee maxSalary(Integer id);
    Employee minSalary(Integer id);
    Map<Integer, List<Employee>> companyStaff();

}
