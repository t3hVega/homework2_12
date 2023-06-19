package com.homework212.homework212.service.impl;

import com.homework212.homework212.exceptions.EmployeeAlreadyAddedException;
import com.homework212.homework212.exceptions.EmployeeNotFoundException;
import com.homework212.homework212.model.Employee;
import com.homework212.homework212.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    protected final Map<String, Employee> staff = new HashMap<>();
    @Override
    public Employee addEmployee(String name, Integer salary, Integer id) {
        String employeeKey = getEmployeeKey(name);

        if (staff.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже нанят");
        }

        staff.put(
                employeeKey,
                new Employee(name, salary, id)
        );

        return staff.get(employeeKey);
    }
    @Override
    public String removeEmployee(String name) {
        String employeeKey = getEmployeeKey(name);

        if (!staff.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        String firedName = staff.get(employeeKey).getName();
        staff.remove(employeeKey);
        return firedName + " уволен";
    }
    @Override
    public Employee findEmployee(String name) {
        String employeeKey = getEmployeeKey(name);

        if (!staff.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        return staff.get(employeeKey);
    }
    @Override
    public Map<String, Employee> staff() {
        return staff;
    }
    private String getEmployeeKey(String name) {
        return name;
    }

}
