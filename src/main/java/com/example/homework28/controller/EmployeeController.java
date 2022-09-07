package com.example.homework28.controller;

import com.example.homework28.model.Employee;
import com.example.homework28.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String name,
                        @RequestParam("lastName") String surname,
                        @RequestParam("salary") String salary,
                        @RequestParam("departmentId") String department) {
        return employeeService.addEmployee(name, surname, salary, department);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String name,
                           @RequestParam("lastName") String surname,
                           @RequestParam("salary") String salary,
                           @RequestParam("departmentId") String department) {
        return employeeService.removeEmployee(name, surname, salary, department);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String name,
                         @RequestParam("lastName") String surname,
                         @RequestParam("salary") String salary,
                         @RequestParam("departmentId") String department) {
        return employeeService.findEmployee(name, surname, salary, department);
    }


}

