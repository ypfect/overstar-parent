package com.overstar.commonbase.exception;

/**
 * definition work exception
 *
 */
public class ExceptionElasticSearch extends RuntimeException{
    //错误编码
    private int code;
    //错误描述
    private String message;
    //任意信息
    private Object data;
    //定义基本构造方法

    public ExceptionElasticSearch(int code, String message){
        this.code=code;
        this.message=message;
    }

    public ExceptionElasticSearch(int code, String message, Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public static ExceptionElasticSearch errorBase(int code, String message, Object data){
        return new ExceptionElasticSearch(code,message,data);
    }

    public static ExceptionElasticSearch errorBase(int code, String message){
        return new ExceptionElasticSearch(code,message);
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
