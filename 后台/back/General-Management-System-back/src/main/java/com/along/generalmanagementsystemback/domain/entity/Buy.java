package com.along.generalmanagementsystemback.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 时间 2024年08月06日
 */
@Data
@Builder
public class Buy {

    private Long id;

    private String name;

    private Integer todayBuy;

    private Integer monthBuy;

    private Integer totalBuy;

}
