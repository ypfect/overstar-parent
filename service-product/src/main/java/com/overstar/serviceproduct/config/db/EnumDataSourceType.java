package com.overstar.serviceproduct.config.db;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/20 22:18
 */
public enum EnumDataSourceType {

    PRODUCT("product-source"),
    USER("user-source");
    private String datasourceName;
    EnumDataSourceType(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }
}
