package com.along.generalmanagementsystemback.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 时间 2024年08月09日
 */

@Data
@Builder
public class UserLoginDTO {

    private String name;

    private String password;

}
