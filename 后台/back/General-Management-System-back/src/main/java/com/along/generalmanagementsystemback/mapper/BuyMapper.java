package com.along.generalmanagementsystemback.mapper;

import com.along.generalmanagementsystemback.domain.entity.Buy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 时间 2024年08月06日
 */

@Mapper
public interface BuyMapper {

    List<Buy> selectAll();

}
