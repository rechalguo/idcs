package com.blc.apps.idcs.admin.error;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ReturnVO {
    /**
     * 返回代码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 返回代码，这里需要在枚举中去定义
     * @param code
     */
    public ReturnVO(String code, String msg) {
        this(code, msg, null);
    }

    /**
     * 返回数据，默认返回正确的code和message
     * @param data
     */
    public ReturnVO(String code, String msg, Object data) {
    	this.setCode(code);
        this.setMessage(msg);
        this.setData(data);
    }

    @Override
    public String toString() {
        return "ReturnVO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}