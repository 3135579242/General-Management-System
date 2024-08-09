package com.along.generalmanagementsystemback.controller;

import com.along.generalmanagementsystemback.domain.entity.Buy;
import com.along.generalmanagementsystemback.domain.result.ResponseResult;
import com.along.generalmanagementsystemback.service.IBuyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 时间 2024年08月06日
 */

//@CrossOrigin
@RestController
@RequestMapping("/buy")
public class BuyController {

    @Resource
    private IBuyService iBuyService;

    @GetMapping("/list")
    public ResponseResult<List<Buy>> getBuyList() {
        return ResponseResult.success(iBuyService.getBuyList());
    }

}
