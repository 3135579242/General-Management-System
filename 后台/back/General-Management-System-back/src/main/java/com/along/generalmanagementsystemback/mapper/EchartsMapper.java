package com.along.generalmanagementsystemback.mapper;

import com.along.generalmanagementsystemback.domain.entity.Echarts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EchartsMapper {

    List<Echarts> selectAll();

}
