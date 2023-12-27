package com.goutam.kiranastore.controller;

import com.goutam.kiranastore.model.SaleOrder;
import com.goutam.kiranastore.model.SaleOrderRequest;
import com.goutam.kiranastore.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sale")
public class SaleController {
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping(path = "/createOrder")
    public void addNewOrder(@RequestBody SaleOrderRequest saleOrderRequest) {
        saleService.createOrder(saleOrderRequest);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<SaleOrder> getAllOrders() {
        return saleService.getAllOrders();
    }

    @GetMapping(path = "/filter")
    public @ResponseBody Iterable<SaleOrder> getFilteredOrders(
            @RequestParam(required = false) Long orderId,
            @RequestParam(required = false) String currencyType,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) Long empId) {
        return saleService.getFilteredOrders(orderId, currencyType, customerName, empId);
    }
}
