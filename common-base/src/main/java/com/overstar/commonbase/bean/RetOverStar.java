package com.overstar.commonbase.bean;

/***
 * 返回结果类
 */
public class RetOverStar {
    private boolean success;
    private String message;
    private Object data;
    private int code;
    public RetOverStar() {

    }
    public static RetOverStar sucess(int code, String msg){
        RetOverStar ret = new RetOverStar(true,msg,code);
        return  ret;
    }

    public static RetOverStar success(Object data){
        RetOverStar ret = new RetOverStar(data);
        return  ret;
    }
    public static RetOverStar sucess(int code, String msg, Object data){
        RetOverStar ret = new RetOverStar(true,msg,data,code);
        return  ret;
    }

    public static RetOverStar sucess(int code,  Object data){
        RetOverStar ret = new RetOverStar(true,"eat",data,code);
        return  ret;
    }
    public static RetOverStar failure(int code, String msg){
        RetOverStar ret = new RetOverStar(false,msg,code);
        return  ret;
    }
    public static RetOverStar failure(int code, String msg, Object data){
        RetOverStar ret = new RetOverStar(false,msg,data,code);
        return  ret;
    }
    public RetOverStar(boolean success, String message, Object data, int code) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.code = code;
    }
    public RetOverStar(boolean success, String message, int code) {
        this.success = success;
        this.message = message;
        this.code = code;
    }
    public RetOverStar(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public RetOverStar(Object data) {
        this.message = "success!";
        this.code = 200;
        this.data = data;
        this.success =true;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
