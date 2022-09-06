package com.example.homework28.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    @JsonProperty("firstName")
    private final String name;
    @JsonProperty("lastName")
    private final String surName;
    private final String salary;
    private final String department;

    public Employee(String name, String surName, String salary, String department) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public int getSalary() {
        return Integer.parseInt(salary);
    }
    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);
    }

    @Override
    public String toString() {
        return String.format("ФИ: %s %s", surName, name);
    }
}
