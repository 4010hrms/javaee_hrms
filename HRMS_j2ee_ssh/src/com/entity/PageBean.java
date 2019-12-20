package com.entity;

import java.util.List;

public class PageBean<T> {

	private int currPage;
	private int pageSize;
	private int totalPage;
	private int totalCount;
	private List<T> list;

	
	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + "]";
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	} 

}
