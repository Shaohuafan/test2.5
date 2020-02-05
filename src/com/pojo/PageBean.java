package com.pojo;

import java.util.List;

public class PageBean {
	private int page = 1;// 当前页
	private int rows = 5;// 每页记录数
	private int maxpage;// 最大页
	private List<?> pagelist;// 结果集

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageBean(int page, int rows, int maxpage, List<?> pagelist) {
		super();
		this.page = page;
		this.rows = rows;
		this.maxpage = maxpage;
		this.pagelist = pagelist;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public List<?> getPagelist() {
		return pagelist;
	}

	public void setPagelist(List<?> pagelist) {
		this.pagelist = pagelist;
	}

}
