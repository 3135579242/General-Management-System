package com.along.generalmanagementsystemback;

import com.along.generalmanagementsystemback.mapper.BuyMapper;
import com.along.generalmanagementsystemback.mapper.OrderMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneralManagementSystemBackApplicationTests {

    @Resource
    private BuyMapper buyMapper;

    @Resource
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
        System.out.println(orderMapper.selectAll());
    }

}
