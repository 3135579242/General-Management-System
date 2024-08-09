package com.along.generalmanagementsystemback.domain.result;


public enum ResultEnum {

    SUCCESS(200,"成功"),
    FAILED(600,"失败");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
