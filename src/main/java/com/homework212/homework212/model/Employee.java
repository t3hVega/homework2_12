package com.homework212.homework212.model;

import java.util.Objects;

public class Employee {

    private String name;
    private Integer salary;
    private Integer id;
    public Employee(String name, Integer salary, Integer id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public Integer getSalary() {
        return salary;
    }
    public Integer getId() { return id; }

    @Override
    public String toString() {
        return  "[" + name + " ," +
                salary +  " ," +
                id +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary) && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, id);
    }
}

