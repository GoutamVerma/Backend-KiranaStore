package com.goutam.kiranastore.services;

import com.goutam.kiranastore.model.ExchangeRateModel;
import com.goutam.kiranastore.model.Product;
import com.goutam.kiranastore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(int ID, String name, String category, int qty, Double unitPrice, String currencyType) {
        Product product = new Product();
        ExchangeRateModel exchangeRateModel = ExchangeRate.getExchangeRateData();

        product.setName(name);
        product.setProductId(ID);
        product.setCategory(category);
        product.setQuantity(qty);
        product.setUnitPrice(unitPrice);
        product.setCurrencyType(currencyType);
        product.setTimestamp(exchangeRateModel.getTimestamp());

        productRepository.save(product);

        return product;
    }
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getFilteredProducts(String category, Integer id, String productName, String currencyType) {
        return productRepository.findFilteredProducts(category, id, productName, currencyType);
    }
}

