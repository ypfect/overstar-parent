package com.overstar.elasticsearch.dto;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`product_base`")
public class ProductBase implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.product_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.product_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String productNameZh;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.product_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String productNameEn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.type_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer typeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.product_status
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer productStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.country_ids
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String countryIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.currency_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer currencyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.comment_num
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer commentNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.play_days
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer playDays;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.hotel_nights
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer hotelNights;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.remark
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.deleted
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.purchase_num
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer purchaseNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.discount
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Double discount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.confirmation_flag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer confirmationFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.recommend_flag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Boolean recommendFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.source_channel
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private Integer sourceChannel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.source_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String sourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_base.city_ids
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private String cityIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table product_base
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.product_id
     *
     * @return the value of product_base.product_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.product_id
     *
     * @param productId the value for product_base.product_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.product_name_zh
     *
     * @return the value of product_base.product_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getProductNameZh() {
        return productNameZh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.product_name_zh
     *
     * @param productNameZh the value for product_base.product_name_zh
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setProductNameZh(String productNameZh) {
        this.productNameZh = productNameZh == null ? null : productNameZh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.product_name_en
     *
     * @return the value of product_base.product_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getProductNameEn() {
        return productNameEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.product_name_en
     *
     * @param productNameEn the value for product_base.product_name_en
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn == null ? null : productNameEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.type_id
     *
     * @return the value of product_base.type_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.type_id
     *
     * @param typeId the value for product_base.type_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.product_status
     *
     * @return the value of product_base.product_status
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.product_status
     *
     * @param productStatus the value for product_base.product_status
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.country_ids
     *
     * @return the value of product_base.country_ids
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getCountryIds() {
        return countryIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.country_ids
     *
     * @param countryIds the value for product_base.country_ids
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCountryIds(String countryIds) {
        this.countryIds = countryIds == null ? null : countryIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.currency_id
     *
     * @return the value of product_base.currency_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getCurrencyId() {
        return currencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.currency_id
     *
     * @param currencyId the value for product_base.currency_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.comment_num
     *
     * @return the value of product_base.comment_num
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getCommentNum() {
        return commentNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.comment_num
     *
     * @param commentNum the value for product_base.comment_num
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.play_days
     *
     * @return the value of product_base.play_days
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getPlayDays() {
        return playDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.play_days
     *
     * @param playDays the value for product_base.play_days
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setPlayDays(Integer playDays) {
        this.playDays = playDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.hotel_nights
     *
     * @return the value of product_base.hotel_nights
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getHotelNights() {
        return hotelNights;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.hotel_nights
     *
     * @param hotelNights the value for product_base.hotel_nights
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setHotelNights(Integer hotelNights) {
        this.hotelNights = hotelNights;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.remark
     *
     * @return the value of product_base.remark
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.remark
     *
     * @param remark the value for product_base.remark
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.deleted
     *
     * @return the value of product_base.deleted
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.deleted
     *
     * @param deleted the value for product_base.deleted
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.purchase_num
     *
     * @return the value of product_base.purchase_num
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.purchase_num
     *
     * @param purchaseNum the value for product_base.purchase_num
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.discount
     *
     * @return the value of product_base.discount
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.discount
     *
     * @param discount the value for product_base.discount
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.confirmation_flag
     *
     * @return the value of product_base.confirmation_flag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getConfirmationFlag() {
        return confirmationFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.confirmation_flag
     *
     * @param confirmationFlag the value for product_base.confirmation_flag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setConfirmationFlag(Integer confirmationFlag) {
        this.confirmationFlag = confirmationFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.recommend_flag
     *
     * @return the value of product_base.recommend_flag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Boolean getRecommendFlag() {
        return recommendFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.recommend_flag
     *
     * @param recommendFlag the value for product_base.recommend_flag
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setRecommendFlag(Boolean recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.source_channel
     *
     * @return the value of product_base.source_channel
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public Integer getSourceChannel() {
        return sourceChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.source_channel
     *
     * @param sourceChannel the value for product_base.source_channel
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setSourceChannel(Integer sourceChannel) {
        this.sourceChannel = sourceChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.source_id
     *
     * @return the value of product_base.source_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.source_id
     *
     * @param sourceId the value for product_base.source_id
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_base.city_ids
     *
     * @return the value of product_base.city_ids
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public String getCityIds() {
        return cityIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_base.city_ids
     *
     * @param cityIds the value for product_base.city_ids
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    public void setCityIds(String cityIds) {
        this.cityIds = cityIds == null ? null : cityIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_base
     *
     * @mbggenerated Thu Mar 28 21:11:43 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productNameZh=").append(productNameZh);
        sb.append(", productNameEn=").append(productNameEn);
        sb.append(", typeId=").append(typeId);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", countryIds=").append(countryIds);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", commentNum=").append(commentNum);
        sb.append(", playDays=").append(playDays);
        sb.append(", hotelNights=").append(hotelNights);
        sb.append(", remark=").append(remark);
        sb.append(", deleted=").append(deleted);
        sb.append(", purchaseNum=").append(purchaseNum);
        sb.append(", discount=").append(discount);
        sb.append(", confirmationFlag=").append(confirmationFlag);
        sb.append(", recommendFlag=").append(recommendFlag);
        sb.append(", sourceChannel=").append(sourceChannel);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", cityIds=").append(cityIds);
        sb.append("]");
        return sb.toString();
    }
}