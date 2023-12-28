package com.goutam.kiranastore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "address")
    private String address;

    @Column(name = "designation")
    private String designation;

    public Employee(String empName, String address, String designation) {
        this.empName = empName;
        this.address = address;
        this.designation = designation;
    }

    public Employee() {

    }
}
