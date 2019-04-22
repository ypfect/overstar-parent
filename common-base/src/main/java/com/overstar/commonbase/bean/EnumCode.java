package com.overstar.commonbase.bean;

/**
 * @Description 常用状态码
 * @Author stanley.yu
 * @Date 2019/4/22 21:10
 */
public enum  EnumCode {

    SUCCESS(200,"成功"), FBI(403,"禁止"), FAILURE(500,"失败"), EXCEPTION(400,"异常"), WAIT(250,"等待"), RETRY(330,"重试");

    private int code;
    private String desc;

    EnumCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
