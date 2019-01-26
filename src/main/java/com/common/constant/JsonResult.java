package com.common.constant;

import java.io.Serializable;

/**
 * @program: JsonResult
 * @description: 前后台交互返回json对象
 * @author: chengy
 * @create: 2018-11-14 09:18
 **/
public class JsonResult implements Serializable {
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;
    private static final long serialVersionUID = -3644950655568598241L;
    /**
     * 是否成功的标识，成功是1，失败是0
     */
    private int state;
    /**
     * 成功时候,返回的JSON数据
     */
    private Object data;
    /**
     * 成功或失败的时候，返回的信息
     */
    private String message;


    public JsonResult() {
    }


    public JsonResult(int state, Object data, String message) {
        this.state = state;
        this.data = data;
        this.message = message;
    }

    public JsonResult(Throwable e) {
        state = ERROR;
        data = null;
        message = e.getMessage();
    }

    public JsonResult(Object data) {
        state = SUCCESS;
        this.data = data;
        message = "";
    }

    public int getState() {
        return state;
    }


    public void setState(int state) {
        this.state = state;
    }


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


    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", data=" + data + ", message=" + message + "]";
    }

}
