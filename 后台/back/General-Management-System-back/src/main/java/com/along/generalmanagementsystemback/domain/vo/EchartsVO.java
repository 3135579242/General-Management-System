package com.along.generalmanagementsystemback.domain.vo;

import com.along.generalmanagementsystemback.domain.entity.Echarts;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 时间 2024年08月06日
 */

@Data
@Builder
public class EchartsVO {

    private List<String> date;

    private List<Map<String,Integer>> data;

    private List<Echarts> videoData;

    private List<Echarts> userData;

}
