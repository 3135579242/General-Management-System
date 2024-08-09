package com.along.generalmanagementsystemback.domain.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 时间 2024年08月06日
 */



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> ResponseResult<T> success(){
        return new ResponseResult<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),null);
    }

    public static <T> ResponseResult<T> success(T data){
        return new ResponseResult<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
    }

    public static ResponseResult<Void> failed(){
        return new ResponseResult<>(ResultEnum.FAILED.getCode(),ResultEnum.FAILED.getMessage(),null);
    }

    public static ResponseResult<Void> failed(String message){
        return new ResponseResult<>(ResultEnum.FAILED.getCode(),message,null);
    }

}
