package com.along.generalmanagementsystemback.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 时间 2024年08月09日
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {

    private Long id;

    private String path;

    private String name;

    private String label;

    private String icon;

    private String url;

    private Long children;

    private List<Menu> childrenItem;


}
