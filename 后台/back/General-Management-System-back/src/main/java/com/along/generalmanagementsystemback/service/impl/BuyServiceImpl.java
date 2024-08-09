package com.along.generalmanagementsystemback.service.impl;

import com.along.generalmanagementsystemback.domain.entity.Buy;
import com.along.generalmanagementsystemback.mapper.BuyMapper;
import com.along.generalmanagementsystemback.service.IBuyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 时间 2024年08月06日
 */

@Service
public class BuyServiceImpl implements IBuyService {

    @Resource
    private BuyMapper buyMapper;

    @Override
    public List<Buy> getBuyList() {
        return buyMapper.selectAll();
    }
}
