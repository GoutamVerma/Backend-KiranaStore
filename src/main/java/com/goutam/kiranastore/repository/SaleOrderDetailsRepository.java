package com.goutam.kiranastore.repository;

import com.goutam.kiranastore.model.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface SaleOrderDetailsRepository extends CrudRepository<OrderDetail, Integer> { }
