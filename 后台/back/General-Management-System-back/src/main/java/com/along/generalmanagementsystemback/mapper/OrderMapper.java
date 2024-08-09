package com.along.generalmanagementsystemback.mapper;

import com.along.generalmanagementsystemback.domain.entity.OrderTotal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {


    List<OrderTotal> selectAll();

}
