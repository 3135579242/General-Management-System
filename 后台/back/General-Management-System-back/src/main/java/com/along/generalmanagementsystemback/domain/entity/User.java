package com.along.generalmanagementsystemback.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 时间 2024年08月07日
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String password;

    private Integer age;

    private Integer gender;

    private String birthDate;

    private String address;

}
