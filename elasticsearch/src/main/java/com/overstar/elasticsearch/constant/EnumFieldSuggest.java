package com.overstar.elasticsearch.constant;

/**
 * @Description 字段枚举--> suggest
 * @Author stanley.yu
 * @Date 2019/4/29 21:50
 */
public enum EnumFieldSuggest {
    PRODUCT_NAME_ZH("productNameZh",90),
    PRODUCT_NAME_ZH_PY("productNameZhPy",80),
    PRODUCT_ID("productId",70),
    TAGS_NAME_ZH("tagNamesZh",60),
    TAGS_NAME_ZH_PY("tagNamesZhPy",60),
    COUNTRY_NAME_ZH("countryNameZh",95),
    COUNTRY_NAME_ZH_PY("countryNameZhPy",95),
    COUNTRY_NAME_EN("countryNameEn",60),
    CITY_NAME_ZH("cityNameZh",70),
    CITY_NAME_ZH_PY("cityNameZhPy",70),
    CITY_NAME_EN("cityNameEn",77),
    VIEW_SPORTS_ZH("viewSpotsZh",66),
    VIEW_SPORTS_ZH_PY("viewSpotsZhPy",55),
    SUPPLIER_NAME("supplierName",30)
    ;
    private String field;
    private double weight;
    EnumFieldSuggest(String field, double weight) {
        this.field = field;
        this.weight = weight;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
