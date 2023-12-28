package com.goutam.kiranastore.repository;

import com.goutam.kiranastore.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> { }
