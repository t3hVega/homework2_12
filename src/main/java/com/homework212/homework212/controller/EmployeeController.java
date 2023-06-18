package com.homework212.homework212.controller;

import com.homework212.homework212.model.Employee;
import com.homework212.homework212.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(
            @RequestParam("name") String name,
            @RequestParam("salary") Integer salary,
            @RequestParam("id") Integer id
    ) {
        return employeeService.addEmployee(name, salary, id);
    }

    @GetMapping("/remove")
    public String remove(
            @RequestParam("name") String name
    ) {
        return employeeService.removeEmployee(name);
    }

    @GetMapping("/find")
    public Employee find(
            @RequestParam("firstName") String name
    ) {
        return employeeService.findEmployee(name);
    }

    @GetMapping("/staff")
    public Map<String,Employee> staff() {
        return employeeService.staff();
    }
}
