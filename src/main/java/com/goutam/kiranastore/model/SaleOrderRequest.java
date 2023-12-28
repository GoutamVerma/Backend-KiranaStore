package com.goutam.kiranastore.model;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class SaleOrderRequest {
    private Long empId;
    private String customerName;
    private String currencyType;
    private Map<Integer, Integer> productQuantities;
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Map<Integer, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Integer, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }
}
