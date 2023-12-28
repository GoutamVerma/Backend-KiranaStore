package com.goutam.kiranastore.repository;

import com.goutam.kiranastore.model.SaleOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleRepository extends CrudRepository<SaleOrder,Integer> {
    @Query("SELECT s FROM SaleOrder s WHERE " +
            "(:orderId IS NULL OR s.orderId = :orderId) " +
            "AND (:currencyType IS NULL OR s.currencyType = :currencyType) " +
            "AND (:customerName IS NULL OR s.customerName = :customerName) " +
            "AND (:empId IS NULL OR s.empId = :empId)")
    List<SaleOrder> findFilteredOrders(
            @Param("orderId") Long orderId,
            @Param("currencyType") String currencyType,
            @Param("customerName") String customerName,
            @Param("empId") Long empId
    );

}
