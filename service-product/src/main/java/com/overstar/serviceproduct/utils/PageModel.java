package com.overstar.serviceproduct.utils;

import java.io.Serializable;
import java.util.List;


public class PageModel<T> implements Serializable {
	private static final long serialVersionUID = -7303181925759700223L;


	/** 当前页码 */
	private int page;
	/** 每页数量 */
	private int size;
	/** 总数量 */
	private int total;
	/** 数据 */
	private List<T> data;

	public PageModel() {
	}

	public PageModel(int page, int size) {
		super();
		this.page = page;
		this.size = size;
	}

	public int getPage() {
		if (page < 1) {
			return 1;
		}
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		if (size < 0) {
			return 0;
		}
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PageModel [page=" + page + ", size=" + size + ", total=" + total + ", data=" + data + "]";
	}

}
