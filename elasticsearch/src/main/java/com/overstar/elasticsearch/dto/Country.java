package com.overstar.elasticsearch.dto;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`country`")
public class Country implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.country_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer countryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.country_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String countryNameZh;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.country_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String countryNameEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.country_code
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String countryCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.phone_code
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String phoneCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.time_lag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String timeLag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.show
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Boolean show;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.country_name_spelling
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String countryNameSpelling;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.zone_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer zoneId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.show_order
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer showOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table country
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.country_id
     *
     * @return the value of country.country_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.country_id
     *
     * @param countryId the value for country.country_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.country_name_zh
     *
     * @return the value of country.country_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getCountryNameZh() {
        return countryNameZh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.country_name_zh
     *
     * @param countryNameZh the value for country.country_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryNameZh(String countryNameZh) {
        this.countryNameZh = countryNameZh == null ? null : countryNameZh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.country_name_en
     *
     * @return the value of country.country_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getCountryNameEn() {
        return countryNameEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.country_name_en
     *
     * @param countryNameEn the value for country.country_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn == null ? null : countryNameEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.country_code
     *
     * @return the value of country.country_code
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.country_code
     *
     * @param countryCode the value for country.country_code
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.phone_code
     *
     * @return the value of country.phone_code
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getPhoneCode() {
        return phoneCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.phone_code
     *
     * @param phoneCode the value for country.phone_code
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode == null ? null : phoneCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.time_lag
     *
     * @return the value of country.time_lag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getTimeLag() {
        return timeLag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.time_lag
     *
     * @param timeLag the value for country.time_lag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setTimeLag(String timeLag) {
        this.timeLag = timeLag == null ? null : timeLag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.show
     *
     * @return the value of country.show
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Boolean getShow() {
        return show;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.show
     *
     * @param show the value for country.show
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setShow(Boolean show) {
        this.show = show;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.country_name_spelling
     *
     * @return the value of country.country_name_spelling
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getCountryNameSpelling() {
        return countryNameSpelling;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.country_name_spelling
     *
     * @param countryNameSpelling the value for country.country_name_spelling
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryNameSpelling(String countryNameSpelling) {
        this.countryNameSpelling = countryNameSpelling == null ? null : countryNameSpelling.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.zone_id
     *
     * @return the value of country.zone_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getZoneId() {
        return zoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.zone_id
     *
     * @param zoneId the value for country.zone_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.show_order
     *
     * @return the value of country.show_order
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getShowOrder() {
        return showOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.show_order
     *
     * @param showOrder the value for country.show_order
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", countryId=").append(countryId);
        sb.append(", countryNameZh=").append(countryNameZh);
        sb.append(", countryNameEn=").append(countryNameEn);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", phoneCode=").append(phoneCode);
        sb.append(", timeLag=").append(timeLag);
        sb.append(", show=").append(show);
        sb.append(", countryNameSpelling=").append(countryNameSpelling);
        sb.append(", zoneId=").append(zoneId);
        sb.append(", showOrder=").append(showOrder);
        sb.append("]");
        return sb.toString();
    }
}