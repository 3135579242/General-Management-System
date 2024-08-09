package com.along.generalmanagementsystemback.domain.vo;

import com.along.generalmanagementsystemback.domain.entity.Menu;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 时间 2024年08月09日
 */

@Builder
@Data
public class MenuListVO {

    private List<Menu> menuList;

    private List<Menu> children;


}
