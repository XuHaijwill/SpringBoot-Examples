package com.hendisantika.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description //TODO
 * @Author XuHaijwill
 * @Date 2024/7/21 16:40
 * @Version 1.0
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 6308315887056661996L;
    private Integer code;
    private String message;
    private T data;


    public Result setResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public Result setResult(ResultCode resultCode,T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.setData(data);
        return this;
    }


}
