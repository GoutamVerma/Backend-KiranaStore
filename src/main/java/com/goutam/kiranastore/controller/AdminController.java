package com.goutam.kiranastore.controller;

import com.goutam.kiranastore.model.Employee;
import com.goutam.kiranastore.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/employee")
public class AdminController {

    private final EmployeeService employeeService;

    @Autowired
    public AdminController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public @ResponseBody Employee addNewEmployee(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String designation) {
        return employeeService.addEmployee(name, address, designation);
    }

    @GetMapping("/all_employee")
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}