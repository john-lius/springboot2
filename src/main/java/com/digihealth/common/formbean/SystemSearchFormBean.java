package com.digihealth.common.formbean;

import java.io.Serializable;

public class SystemSearchFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer page;

	private Integer limit;

	private String sort;

	private String orderBy;

	public Integer getPage() {
		if (page == null) {
			return 0;
		} else if (page == 0) {
			return 0;
		} else {
			return (page - 1) * limit;
		}
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
