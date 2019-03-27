package com.overstar.serviceproduct.bean;

import java.io.Serializable;

public class ProductDocument implements Serializable {
	private static final long serialVersionUID = -2549139565527611835L;
	//产品ID
	private String productId;
	// 对应产品名称,中文模糊匹配字段（与查询条件中的searchKey匹配）
	private String productNameZh;
	// 对应产品名称,英文
	private String productNameEn;
	// 标签名列表，多个名称之间用逗号分隔开
	private String tagNamesZh;
	// 国家名称列表，中文，多个之间用逗号隔开
	private String countryNameZh;
	// 国家名称列表，英文，多个之间用逗号隔开
	private String countryNameEn;
	// 城市名称列表，中文，多个之间用逗号隔开
	private String cityNameZh;
	// 城市名称列表，英文，多个之间用逗号隔开
	private String cityNameEn;
	// 景点中文名称，多个之间用英文逗号隔开
	private String viewSpotsZh;
	//供应商名称
	private String supplierName;
	// 搜索评分
	private Float score;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductNameZh() {
		return productNameZh;
	}

	public void setProductNameZh(String productNameZh) {
		this.productNameZh = productNameZh;
	}

	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	public String getTagNamesZh() {
		return tagNamesZh;
	}

	public void setTagNamesZh(String tagNamesZh) {
		this.tagNamesZh = tagNamesZh;
	}

	public String getCountryNameZh() {
		return countryNameZh;
	}

	public void setCountryNameZh(String countryNameZh) {
		this.countryNameZh = countryNameZh;
	}

	public String getCountryNameEn() {
		return countryNameEn;
	}

	public void setCountryNameEn(String countryNameEn) {
		this.countryNameEn = countryNameEn;
	}

	public String getCityNameZh() {
		return cityNameZh;
	}

	public void setCityNameZh(String cityNameZh) {
		this.cityNameZh = cityNameZh;
	}

	public String getCityNameEn() {
		return cityNameEn;
	}

	public void setCityNameEn(String cityNameEn) {
		this.cityNameEn = cityNameEn;
	}

	public String getViewSpotsZh() {
		return viewSpotsZh;
	}

	public void setViewSpotsZh(String viewSpotsZh) {
		this.viewSpotsZh = viewSpotsZh;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "ProductDocument [productId=" + productId
				+ ", productNameZh=" + productNameZh + ", productNameEn="
				+ productNameEn + ", tagNamesZh=" + tagNamesZh
				+ ", countryNameZh=" + countryNameZh + ", countryNameEn="
				+ countryNameEn + ", cityNameZh=" + cityNameZh
				+ ", cityNameEn=" + cityNameEn + ", viewSpotsZh=" + viewSpotsZh
				+ ", supplierName=" + supplierName + ", score=" + score + "]";
	}
	
}
