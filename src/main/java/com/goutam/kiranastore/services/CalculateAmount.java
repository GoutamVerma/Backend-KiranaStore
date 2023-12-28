package com.goutam.kiranastore.services;

import com.goutam.kiranastore.model.CalculateProductSell;
import com.goutam.kiranastore.repository.CurrencyRepository;

import java.util.List;

public class CalculateAmount {
    public static Double calculate_amt(String currency_type, List<CalculateProductSell> products_info,CurrencyRepository currencyRepository) {
        Double total_amount = 0.0;
        System.out.println(currency_type);
        if ("USD".equals(currency_type)) {
            for (CalculateProductSell product : products_info) {
                if ("USD".equals(product.getCurrencyType())) {
                    total_amount += product.getQty() * product.getUnitPrice();
                } else if ("INR".equals(product.getCurrencyType())) {
                    Double inr_rate = currencyRepository.findInrRateByTimestamp(product.getTimestamp());
                    total_amount += product.getQty() * (product.getUnitPrice() / inr_rate);
                }
            }
        } else if ("INR".equals(currency_type)) {
            for (CalculateProductSell product : products_info) {
                if ("INR".equals(product.getCurrencyType())) {
                    total_amount += product.getQty() * product.getUnitPrice();
                } else if ("USD".equals(product.getCurrencyType())) {
                    Double usd_rate = currencyRepository.findInrRateByTimestamp(product.getTimestamp());
                    System.out.println(usd_rate + " INR RATE AAYA HAI!");
                    total_amount += product.getQty() * (product.getUnitPrice() * usd_rate);
                }
            }
        }
        return total_amount;
    }
}
