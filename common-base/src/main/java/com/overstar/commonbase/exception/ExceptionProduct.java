package com.overstar.commonbase.exception;

/**
 * definition work exception
 *
 */
public class ExceptionProduct extends RuntimeException{
    //错误编码
    private int code;
    //错误描述
    private String message;
    //任意信息
    private Object data;
    //定义基本构造方法

    public ExceptionProduct(int code, String message){
        this.code=code;
        this.message=message;
    }

    public ExceptionProduct(int code, String message, Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public static ExceptionProduct errorBase(int code, String message, Object data){
        return new ExceptionProduct(code,message,data);
    }

    public static ExceptionProduct errorBase(int code, String message){
        return new ExceptionProduct(code,message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
