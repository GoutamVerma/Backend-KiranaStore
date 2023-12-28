package com.goutam.kiranastore.services;

import com.goutam.kiranastore.model.Employee;
import com.goutam.kiranastore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(String name, String address, String designation) {
        Employee employee = new Employee(name,address,designation);
        return employeeRepository.save(employee);
    }
}