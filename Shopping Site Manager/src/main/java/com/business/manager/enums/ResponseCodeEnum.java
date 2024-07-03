package com.business.manager.enums;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {
    SUCCESS(200,"请求成功"),
    SUCCESS_ADDRESS(201,"请求成功"),
    LOGIN(401,"请登录"),
    LOGIN_EXPIRED(402,"登录过期，请重新登录"),
    FORBINDEN(403,"您已被禁用"),
    ERROR(500,"请求错误"),
    PARAM_INVALID(501,"参数不完整");



    private ResponseCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    private Integer code;
    private String message;
}
