package com.overstar.serviceproduct.bean;

import com.overstar.commonbase.bean.PageQuery;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/21 21:23
 */
public class ProductQuery extends PageQuery {
    private int productId;
    private String productName;
    private int productType;
    private List<Integer> productStatus;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public List<Integer> getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(List<Integer> productStatus) {
        this.productStatus = productStatus;
    }
}
