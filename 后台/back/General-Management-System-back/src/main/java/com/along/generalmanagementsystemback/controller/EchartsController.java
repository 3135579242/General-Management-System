package com.along.generalmanagementsystemback.controller;

import com.along.generalmanagementsystemback.domain.entity.Echarts;
import com.along.generalmanagementsystemback.domain.result.ResponseResult;
import com.along.generalmanagementsystemback.domain.vo.EchartsVO;
import com.along.generalmanagementsystemback.service.IEchartsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 时间 2024年08月06日
 */

@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Resource
    private IEchartsService iEchartsService;

    @GetMapping("/list")
    public ResponseResult<EchartsVO> getEchartsList(){
        return ResponseResult.success(iEchartsService.getEchartsList());
    }

}
