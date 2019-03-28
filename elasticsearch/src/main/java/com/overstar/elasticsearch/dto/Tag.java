package com.overstar.elasticsearch.dto;

import java.io.Serializable;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 21:30
 */
public class Tag implements Serializable {

    private int id;
    private String  nameZh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
