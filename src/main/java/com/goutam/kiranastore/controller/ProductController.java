package com.goutam.kiranastore.controller;

import com.goutam.kiranastore.model.Product;
import com.goutam.kiranastore.services.CurrencyService;
import com.goutam.kiranastore.services.ExchangeRate;
import com.goutam.kiranastore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CurrencyService currencyService;

    @Autowired
    public ProductController(ProductService productService, CurrencyService currencyService) {
        this.productService = productService;
        this.currencyService = currencyService;
    }

    @PostMapping("/order")
    public @ResponseBody Product addNewOrder(
            @RequestParam int ID,
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam int qty,
            @RequestParam Double unitPrice,
            @RequestParam String currencyType) {
        Product product = productService.addProduct(ID, name, category, qty, unitPrice, currencyType);
        currencyService.saveCurrency(ExchangeRate.getExchangeRateData());

        return product;
    }


    @GetMapping("/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/filter")
    public @ResponseBody List<Product> getFilteredProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) String currencyType) {

        return productService.getFilteredProducts(category, id, productName, currencyType);
    }
}