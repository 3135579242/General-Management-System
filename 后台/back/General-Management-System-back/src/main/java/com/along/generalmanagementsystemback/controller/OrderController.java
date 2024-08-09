package com.along.generalmanagementsystemback.controller;

import com.along.generalmanagementsystemback.domain.entity.OrderTotal;
import com.along.generalmanagementsystemback.domain.result.ResponseResult;
import com.along.generalmanagementsystemback.service.IOrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 时间 2024年08月06日
 */


@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService iOrderService;

    @GetMapping("/list")
    public ResponseResult<List<OrderTotal>> getOrderList(){
        return ResponseResult.success(iOrderService.getOrderList());
    }

}
