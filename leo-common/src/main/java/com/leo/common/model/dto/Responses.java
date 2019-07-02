package com.leo.common.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leo.common.exception.BuzCode;
import lombok.Data;

import java.io.Serializable;


/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 13:52
 * @Version 1.0
 * @Author: XieLY
 * @Description: 统一返回值
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Responses<T> implements Serializable {


    /**
     * 返回码
     */
    private Integer code = BuzCode.SUCCEED.getCode();

    /**
     * 返回信息
     */
    private String message = BuzCode.SUCCEED.getMessage();

    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回数据
     */
    private T body;
    /**
     * 返回状态 true or false
     */
    private boolean success;
    /**
     * 返回时间
     */
    private long timestamp;

    public static Responses success() {
        return new Responses();
    }

    public static Responses fail() {
        return new Responses(BuzCode.FAILED.getCode(), BuzCode.FAILED.getMessage());
    }

    public static Responses operate(boolean isSucceed) {
        return isSucceed ? success() : fail();
    }

    public Responses() {
    }

    public Responses(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Responses(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Responses(Integer code, String message,boolean success, long timestamp,Object data,T body) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
        this.timestamp = timestamp;
        this.body = body;

    }
}
