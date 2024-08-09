package com.along.generalmanagementsystemback.service;

import com.along.generalmanagementsystemback.domain.entity.OrderTotal;

import java.util.List;

public interface IOrderService {

    List<OrderTotal> getOrderList();

}

