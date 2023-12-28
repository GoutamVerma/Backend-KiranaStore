package com.goutam.kiranastore.repository;

import com.goutam.kiranastore.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    @Query("SELECT p.timeStamp FROM Product p WHERE p.productId = :productId")
    Timestamp findTimestampById(@Param("productId") int productId);

    @Query("SELECT p.unitPrice FROM Product p WHERE p.productId = :productId")
    Double findUnitPriceByProductId(@Param("productId") int productId);

    @Query("SELECT p.currencyType FROM Product p WHERE p.productId = :productId")
    String findCurrencyTypeByProductId(@Param("productId") int productId);

    @Query("SELECT p FROM Product p WHERE " +
            "(:category IS NULL OR p.category = :category) " +
            "AND (:id IS NULL OR p.productId = :id) " +
            "AND (:productName IS NULL OR p.name = :productName) " +
            "AND (:currencyType IS NULL OR p.currencyType = :currencyType)")
    List<Product> findFilteredProducts(
            @Param("category") String category,
            @Param("id") Integer id,
            @Param("productName") String productName,
            @Param("currencyType") String currencyType
    );

}
