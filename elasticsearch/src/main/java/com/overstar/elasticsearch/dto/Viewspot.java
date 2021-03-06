package com.overstar.elasticsearch.dto;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`viewspot`")
public class Viewspot implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.country_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer countryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.city_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.latitude
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.longitude
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.location_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String locationNameZh;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.location_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String locationNameEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.icon
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String icon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.image
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.location_type
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer locationType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.around_locations
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String aroundLocations;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.remark
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column viewspot.deleted
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table viewspot
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.id
     *
     * @return the value of viewspot.id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.id
     *
     * @param id the value for viewspot.id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.country_id
     *
     * @return the value of viewspot.country_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getCountryId() {
        return countryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.country_id
     *
     * @param countryId the value for viewspot.country_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.city_id
     *
     * @return the value of viewspot.city_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.city_id
     *
     * @param cityId the value for viewspot.city_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.latitude
     *
     * @return the value of viewspot.latitude
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.latitude
     *
     * @param latitude the value for viewspot.latitude
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.longitude
     *
     * @return the value of viewspot.longitude
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.longitude
     *
     * @param longitude the value for viewspot.longitude
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.location_name_zh
     *
     * @return the value of viewspot.location_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getLocationNameZh() {
        return locationNameZh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.location_name_zh
     *
     * @param locationNameZh the value for viewspot.location_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setLocationNameZh(String locationNameZh) {
        this.locationNameZh = locationNameZh == null ? null : locationNameZh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.location_name_en
     *
     * @return the value of viewspot.location_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getLocationNameEn() {
        return locationNameEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.location_name_en
     *
     * @param locationNameEn the value for viewspot.location_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setLocationNameEn(String locationNameEn) {
        this.locationNameEn = locationNameEn == null ? null : locationNameEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.icon
     *
     * @return the value of viewspot.icon
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.icon
     *
     * @param icon the value for viewspot.icon
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.image
     *
     * @return the value of viewspot.image
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.image
     *
     * @param image the value for viewspot.image
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.location_type
     *
     * @return the value of viewspot.location_type
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getLocationType() {
        return locationType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.location_type
     *
     * @param locationType the value for viewspot.location_type
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.around_locations
     *
     * @return the value of viewspot.around_locations
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getAroundLocations() {
        return aroundLocations;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.around_locations
     *
     * @param aroundLocations the value for viewspot.around_locations
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setAroundLocations(String aroundLocations) {
        this.aroundLocations = aroundLocations == null ? null : aroundLocations.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.remark
     *
     * @return the value of viewspot.remark
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.remark
     *
     * @param remark the value for viewspot.remark
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column viewspot.deleted
     *
     * @return the value of viewspot.deleted
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column viewspot.deleted
     *
     * @param deleted the value for viewspot.deleted
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table viewspot
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", countryId=").append(countryId);
        sb.append(", cityId=").append(cityId);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", locationNameZh=").append(locationNameZh);
        sb.append(", locationNameEn=").append(locationNameEn);
        sb.append(", icon=").append(icon);
        sb.append(", image=").append(image);
        sb.append(", locationType=").append(locationType);
        sb.append(", aroundLocations=").append(aroundLocations);
        sb.append(", remark=").append(remark);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}