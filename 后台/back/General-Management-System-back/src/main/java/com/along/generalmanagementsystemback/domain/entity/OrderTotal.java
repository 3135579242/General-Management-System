package com.along.generalmanagementsystemback.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 时间 2024年08月06日
 */

@Data
@Builder
public class OrderTotal {

    private Long id;

    private String name;

    private Integer orderTotal;

    private String icon;

    private String color;

}
