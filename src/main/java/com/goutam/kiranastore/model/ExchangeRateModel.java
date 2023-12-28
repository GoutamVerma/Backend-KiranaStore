package com.goutam.kiranastore.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ExchangeRateModel {
    private BigDecimal usd;
    private BigDecimal inr;
    private Timestamp timestamp;

    public ExchangeRateModel() {
    }

    public ExchangeRateModel(Timestamp timestamp, BigDecimal usd, BigDecimal inr) {
        this.timestamp = timestamp;
        this.inr = inr;
        this.usd = usd;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    public BigDecimal getInr() {
        return inr;
    }

    public void setInr(BigDecimal inr) {
        this.inr = inr;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
