package com.overstar.elasticsearch.bean;

import com.overstar.commonbase.bean.PageQuery;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 22:49
 */
public class EsSearchQuery extends PageQuery {

    private String index;
    private int pageNum;
    private int size;
    private String key;
    private int returnSize;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public int getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getReturnSize() {
        return returnSize;
    }

    public void setReturnSize(int returnSize) {
        this.returnSize = returnSize;
    }
}
