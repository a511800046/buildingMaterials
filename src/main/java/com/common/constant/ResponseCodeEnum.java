package com.common.constant;

/**
 * @program: web_interface
 * @description: 响应码和响应信息
 * @author: chengy
 * @create: 2018-07-09 16:37
 **/
public enum ResponseCodeEnum {
    成功("成功", "1"),
    失败("失败", "0");

    private String ResponseMSG;
    private String ResponseCode;

    private ResponseCodeEnum(String ResponseMSG, String ResponseCode) {
        this.ResponseMSG = ResponseMSG;
        this.ResponseCode = ResponseCode;
    }

    public String getResponseMSG() {
        return ResponseMSG;
    }

    public void setResponseMSG(String responseMSG) {
        ResponseMSG = responseMSG;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }


}
