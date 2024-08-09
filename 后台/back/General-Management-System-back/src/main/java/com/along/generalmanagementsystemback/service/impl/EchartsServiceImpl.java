package com.along.generalmanagementsystemback.service.impl;

import com.along.generalmanagementsystemback.domain.entity.Echarts;
import com.along.generalmanagementsystemback.domain.vo.EchartsVO;
import com.along.generalmanagementsystemback.mapper.EchartsMapper;
import com.along.generalmanagementsystemback.service.IEchartsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 时间 2024年08月06日
 */
@Service
public class EchartsServiceImpl implements IEchartsService {

    @Resource
    private EchartsMapper echartsMapper;

    @Override
    public EchartsVO getEchartsList() {
        List<Echarts> echartss = echartsMapper.selectAll();
        echartss.forEach(System.out::println);
        //日期属性
        List<String> date = echartss.stream().map(e -> new SimpleDateFormat("yyyy-MM-dd").format(e.getDateNum())).collect(Collectors.toList());
        //data属性
        List<Map<String, Integer>> data = new ArrayList<>();
        Map<String, Integer> data1 = echartss.stream().collect(Collectors.toMap(Echarts::getName, Echarts::getPrice));
        data.add(data1);
        for (int i = 1; i <= 8; i++){
            Map<String, Integer> elements = echartss.stream().collect(Collectors.toMap(Echarts::getName,e -> e.getPrice() * new Random().nextInt(5) + 1));
            data.add(elements);
        }
        //videoData
        List<Echarts> videoData = echartss.stream().map(e -> Echarts.builder().name(e.getName()).price(e.getPrice()).build()).collect(Collectors.toList());
        //userData
        List<Echarts> userData = echartss.stream().map(e -> Echarts.builder().date(e.getDate()).news(e.getNews()).active(e.getActive() * new Random().nextInt(3) + 1).build()).collect(Collectors.toList());
        return EchartsVO.builder()
                .date(date)
                .data(data)
                .videoData(videoData)
                .userData(userData)
                .build();
    }

}
