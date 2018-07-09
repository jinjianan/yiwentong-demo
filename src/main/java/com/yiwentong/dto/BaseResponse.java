package com.yiwentong.dto;

public class BaseResponse<T extends Object> {

    private String code;		//状态码
    private String message;		//消息
    private T data;				//返回对象

    public BaseResponse(){}

    public BaseResponse(String code,String message){
        this.code = code;
        this.message = message;
    }
    public BaseResponse(String code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
