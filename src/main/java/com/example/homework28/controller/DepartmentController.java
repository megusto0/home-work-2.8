package com.example.homework28.controller;

import com.example.homework28.model.Employee;
import com.example.homework28.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final EmployeeService employeeService;
    public DepartmentController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam("departmentId") String department) {
        return employeeService.findMaxSalary(department);
    }

    @GetMapping("/mix-salary")
    public Employee findMinSalary(@RequestParam("departmentId") String department) {
        return employeeService.findMinSalary(department);
    }

    @GetMapping("/all")
    public List<Employee> all(@RequestParam("departmentId") String department) {
        return employeeService.all(department);
    }

    @GetMapping()
    public Map<String, List<Employee>> getAll() {
        return employeeService.getAll();
    }
}
