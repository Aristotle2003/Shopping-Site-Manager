package com.business.manager.util;

import com.business.manager.enums.ResponseCodeEnum;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 返回数据体
 * @param <T>
 */
@Data
public class ResponseEntity<T> {
    private boolean success;
    private Integer errorCode;
    private String message;
    private T data;


    public static <T> ResponseEntity<T> SUCCESS(T data,String message){
        ResponseEntity<T> response = new ResponseEntity<>();
        response.setSuccess(true);
        response.setData(data);
        response.setMessage(message);
        return  response;
    }

    public static <T> ResponseEntity<T> SUCCESS(T data){
        return SUCCESS(data,null);
    }
    public static <T> ResponseEntity<T> ERROR(T data,String message,Integer errorCode){
        ResponseEntity<T> response = new ResponseEntity<>();
        response.setSuccess(false);
        response.setData(data);
        response.setMessage(message);
        response.setErrorCode(errorCode);
        return  response;
    }

    public static <T> ResponseEntity<T> ERROR(T data,String message, ResponseCodeEnum codeEnum){
        ResponseEntity<T> response = new ResponseEntity<>();
        response.setSuccess(false);
        response.setData(data);
        response.setMessage(message);
        if (codeEnum != null){
            response.setErrorCode(codeEnum.getCode());
            response.setMessage(codeEnum.getMessage());
        }
        if (StringUtils.hasLength(message)){
            response.setMessage(message);
        }
        return  response;
    }
    public static <T> ResponseEntity<T> ERROR(String message, ResponseCodeEnum codeEnum){
        return ERROR(null,message,codeEnum);
    }
    public static <T> ResponseEntity<T> ERROR(String message){
        return ERROR(message,null);
    }
    public static ResponseEntity ERROR(ResponseCodeEnum codeEnum){
        return ERROR(null,codeEnum);
    }
}
