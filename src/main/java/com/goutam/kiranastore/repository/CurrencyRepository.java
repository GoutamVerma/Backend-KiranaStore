package com.goutam.kiranastore.repository;

import com.goutam.kiranastore.model.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

public interface CurrencyRepository extends CrudRepository<Currency, Integer>{
    @Query("SELECT c.usdRate FROM Currency c WHERE c.timestamp = :timestamp")
    Double findUsdRateByTimestamp(@Param("timestamp") Timestamp timestamp);

    @Query("SELECT c.inrRate FROM Currency c WHERE c.timestamp = :timestamp")
    Double findInrRateByTimestamp(@Param("timestamp") Timestamp timestamp);

}
