package com.overstar.serviceproduct.dto;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`city`")
public class City implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.country_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private Integer countryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city_name_zh
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private String cityNameZh;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city_name_en
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private String cityNameEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city_code
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.show
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private Boolean show;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city_name_spelling
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private String cityNameSpelling;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.hot
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private Boolean hot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.prov_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private Integer provId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.show_order
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private Integer showOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table city
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city_id
     *
     * @return the value of city.city_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city_id
     *
     * @param cityId the value for city.city_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.country_id
     *
     * @return the value of city.country_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.country_id
     *
     * @param countryId the value for city.country_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city_name_zh
     *
     * @return the value of city.city_name_zh
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public String getCityNameZh() {
        return cityNameZh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city_name_zh
     *
     * @param cityNameZh the value for city.city_name_zh
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setCityNameZh(String cityNameZh) {
        this.cityNameZh = cityNameZh == null ? null : cityNameZh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city_name_en
     *
     * @return the value of city.city_name_en
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public String getCityNameEn() {
        return cityNameEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city_name_en
     *
     * @param cityNameEn the value for city.city_name_en
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn == null ? null : cityNameEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city_code
     *
     * @return the value of city.city_code
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city_code
     *
     * @param cityCode the value for city.city_code
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.show
     *
     * @return the value of city.show
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public Boolean getShow() {
        return show;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.show
     *
     * @param show the value for city.show
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setShow(Boolean show) {
        this.show = show;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city_name_spelling
     *
     * @return the value of city.city_name_spelling
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public String getCityNameSpelling() {
        return cityNameSpelling;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city_name_spelling
     *
     * @param cityNameSpelling the value for city.city_name_spelling
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setCityNameSpelling(String cityNameSpelling) {
        this.cityNameSpelling = cityNameSpelling == null ? null : cityNameSpelling.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.hot
     *
     * @return the value of city.hot
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public Boolean getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.hot
     *
     * @param hot the value for city.hot
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.prov_id
     *
     * @return the value of city.prov_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public Integer getProvId() {
        return provId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.prov_id
     *
     * @param provId the value for city.prov_id
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.show_order
     *
     * @return the value of city.show_order
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public Integer getShowOrder() {
        return showOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.show_order
     *
     * @param showOrder the value for city.show_order
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbggenerated Wed Mar 27 14:03:33 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityId=").append(cityId);
        sb.append(", countryId=").append(countryId);
        sb.append(", cityNameZh=").append(cityNameZh);
        sb.append(", cityNameEn=").append(cityNameEn);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", show=").append(show);
        sb.append(", cityNameSpelling=").append(cityNameSpelling);
        sb.append(", hot=").append(hot);
        sb.append(", provId=").append(provId);
        sb.append(", showOrder=").append(showOrder);
        sb.append("]");
        return sb.toString();
    }
}