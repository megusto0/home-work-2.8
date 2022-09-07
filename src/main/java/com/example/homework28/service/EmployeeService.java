package com.example.homework28.service;

import com.example.homework28.exception.EmployeeAlreadyAddedException;
import com.example.homework28.exception.EmployeeNotFoundException;
import com.example.homework28.exception.EmployeeStorageIsFullException;
import com.example.homework28.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final static int SIZE = 5;
    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String name, String surname, String salary, String department) {
        Employee employee = new Employee(name, surname, salary, department);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < SIZE) {
            employees.add(employee);
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();

    }

    public Employee removeEmployee(String name, String surname, String salary, String department) {
        Employee employee = new Employee(name, surname, salary, department);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();


    }

    public Employee findEmployee(String name, String surname, String salary, String department) {
        Employee employee = new Employee(name, surname, salary, department);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    public Employee findMaxSalary(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMinSalary(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> all(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> getAll() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
