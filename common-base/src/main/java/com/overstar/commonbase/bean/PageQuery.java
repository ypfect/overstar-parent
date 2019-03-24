package com.overstar.commonbase.bean;

import java.io.Serializable;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/21 21:22
 */
public class PageQuery implements Serializable {
    private int pageNum;
    private int size;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
