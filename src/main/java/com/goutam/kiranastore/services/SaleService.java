package com.goutam.kiranastore.services;


import com.goutam.kiranastore.model.CalculateProductSell;
import com.goutam.kiranastore.model.OrderDetail;
import com.goutam.kiranastore.model.SaleOrder;
import com.goutam.kiranastore.model.SaleOrderRequest;
import com.goutam.kiranastore.repository.CurrencyRepository;
import com.goutam.kiranastore.repository.ProductRepository;
import com.goutam.kiranastore.repository.SaleOrderDetailsRepository;
import com.goutam.kiranastore.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final SaleOrderDetailsRepository saleOrderDetailsRepository;
    private final CurrencyRepository currencyRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, ProductRepository productRepository,
                       CurrencyRepository currencyRepository, SaleOrderDetailsRepository saleOrderDetailsRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.currencyRepository = currencyRepository;
        this.saleOrderDetailsRepository = saleOrderDetailsRepository;
    }

    public void createOrder(SaleOrderRequest saleOrderRequest) {
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setEmpId(saleOrderRequest.getEmpId());
        saleOrder.setCustomerName(saleOrderRequest.getCustomerName());
        saleOrder.setCurrencyType(saleOrderRequest.getCurrencyType());

        List<CalculateProductSell> productsInfo = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : saleOrderRequest.getProductQuantities().entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();
            Timestamp timestamp = productRepository.findTimestampById(productId);
            Double unitPrice = productRepository.findUnitPriceByProductId(productId);
            String productCurrencyType = productRepository.findCurrencyTypeByProductId(productId);
;
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(productId);
            orderDetail.setQuantity(quantity);
            orderDetail.setSaleOrder(saleOrder);
            saleOrder.addOrderDetail(orderDetail);

            CalculateProductSell calculateProductSell = new CalculateProductSell(timestamp, productCurrencyType, quantity, productId, unitPrice);
            productsInfo.add(calculateProductSell);
        }

        Double totalAmount = CalculateAmount.calculate_amt(saleOrderRequest.getCurrencyType(),productsInfo,currencyRepository);
        saleOrder.setTotalAmount(totalAmount);

        saleRepository.save(saleOrder);
    }

    public Iterable<SaleOrder> getAllOrders() {
        return saleRepository.findAll();
    }

    public Iterable<SaleOrder> getFilteredOrders(Long orderId, String currencyType, String customerName, Long empId) {
        return saleRepository.findFilteredOrders(orderId, currencyType, customerName, empId);
    }
}

