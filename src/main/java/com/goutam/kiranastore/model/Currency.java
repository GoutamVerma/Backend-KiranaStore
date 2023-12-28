package com.goutam.kiranastore.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
import java.math.BigDecimal;


@Entity
@Table(name = "currency_rates")
public class Currency {

    @Id
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "usd", nullable = false)
    private BigDecimal usdRate;

    @Column(name = "inr", nullable = false)
    private BigDecimal inrRate;

    public Currency(Timestamp timestamp, BigDecimal usdRate, BigDecimal inrRate) {
        this.timestamp = timestamp;
        this.usdRate = usdRate;
        this.inrRate = inrRate;
    }

    public Currency() {

    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
