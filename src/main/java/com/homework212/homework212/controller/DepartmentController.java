package com.homework212.homework212.controller;

import com.homework212.homework212.model.Employee;
import com.homework212.homework212.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/employees")
    public Set<Employee> departmentStaff(
            @PathVariable(required = false, value = "id")
            Integer id
    ) {
        return departmentService.departmentStaff(id);
    };

    @GetMapping("{id}/salary/sum")
    public Integer sumSalary(
            @PathVariable(required = false, value = "id")
            Integer id
    ) {
        return departmentService.sumSalary(id);
    };
    @GetMapping("{id}/salary/max")
    public Employee maxSalary(
            @PathVariable(required = false, value = "id")
            Integer id
    ) {
       return departmentService.maxSalary(id);
    }

    @GetMapping("{id}/salary/min")
    public Employee minSalary(
            @PathVariable(required = false, value = "id")
            Integer id
    ) {
        return departmentService.minSalary(id);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> employees(
    ) {
        return departmentService.companyStaff();
    }

}
