package com.goutam.kiranastore.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goutam.kiranastore.model.ExchangeRateModel;

public class ExchangeRate {
    static BigDecimal usdRate;
    static BigDecimal inrRate;

    public static ExchangeRateModel getExchangeRateData() {
        String apiUrl = "https://api.fxratesapi.com/latest";
        ExchangeRateModel exchangeRateModel = new ExchangeRateModel();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.toString());

            String dateString = jsonNode.get("date").asText();
            String formattedTimestampString = dateString.replace("T", " ").replace("Z", "");
            Timestamp timestamp = Timestamp.valueOf(formattedTimestampString);
            usdRate = BigDecimal.valueOf(jsonNode.get("rates").get("USD").asDouble());
            inrRate = BigDecimal.valueOf(jsonNode.get("rates").get("INR").asDouble());
            exchangeRateModel.setTimestamp(timestamp);
            exchangeRateModel.setInr(inrRate);
            exchangeRateModel.setUsd(usdRate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exchangeRateModel;
    }
}