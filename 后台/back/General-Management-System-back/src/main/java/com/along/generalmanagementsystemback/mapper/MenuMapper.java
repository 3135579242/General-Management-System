package com.along.generalmanagementsystemback.mapper;

import com.along.generalmanagementsystemback.domain.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> selectMenuList(Long userId);

    List<Menu> selectByChildrenIdMenuList(Long childrenId);

}
