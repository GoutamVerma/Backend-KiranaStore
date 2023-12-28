package com.goutam.kiranastore.model;

import java.sql.Timestamp;
import java.util.Optional;

public class CalculateProductSell {
    private Timestamp timestamp;
    private String currencyType;
    private int qty;
    private int productId;
    private Double unit_price;

    public CalculateProductSell(Timestamp timestamp, String currencyType, int qty, int productId, Double unitPrice) {
        this.timestamp = timestamp;
        this.currencyType = currencyType;
        this.qty = qty;
        this.productId = productId;
        this.unit_price = unitPrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getCurrencyType() {
        return currencyType;
    }
    public int getQty() {
        return qty;
    }

    public Double getUnitPrice(){
        return unit_price;
    }

}