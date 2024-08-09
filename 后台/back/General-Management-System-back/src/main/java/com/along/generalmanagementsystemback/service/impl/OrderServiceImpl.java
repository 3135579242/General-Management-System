package com.along.generalmanagementsystemback.service.impl;

import com.along.generalmanagementsystemback.domain.entity.OrderTotal;
import com.along.generalmanagementsystemback.mapper.OrderMapper;
import com.along.generalmanagementsystemback.service.IOrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 时间 2024年08月06日
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderTotal> getOrderList() {
        return orderMapper.selectAll();
    }
}
