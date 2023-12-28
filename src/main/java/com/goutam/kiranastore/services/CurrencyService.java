package com.goutam.kiranastore.services;

import com.goutam.kiranastore.model.Currency;
import com.goutam.kiranastore.model.ExchangeRateModel;
import com.goutam.kiranastore.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency saveCurrency(ExchangeRateModel exchangeRateModel) {
        Currency currency = new Currency(exchangeRateModel.getTimestamp(),exchangeRateModel.getUsd(),exchangeRateModel.getInr());
        currencyRepository.save(currency);
        return currency;
    }
}
