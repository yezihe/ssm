package com.yezi.util;

import java.util.List;

public class Pager<T> {
	private Integer total;//总记录数
	private List<T> rows;//每页记录的集合
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	

}
