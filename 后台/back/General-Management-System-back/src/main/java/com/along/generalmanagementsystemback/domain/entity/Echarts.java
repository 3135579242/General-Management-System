package com.along.generalmanagementsystemback.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 时间 2024年08月06日
 */

@Data
@Builder
public class Echarts {



    private Long id;

    private Date dateNum;

    private String date;

    private String name;

    private Integer price;

    private Integer news;

    private Integer active;

}
