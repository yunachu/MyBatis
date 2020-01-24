package com.util;
 
public class Paging {
	private long rows = 5;//한페이지에 보여질 게시글의 수
	private long page = 1;//현재페이지
	private long totalPage;	//전체 페이지 수	
	private long startPage = 1;//시작 페이지
	private long endPage;	//끝 페이지
	private long pageScale = 3;	//한 페이지에 보여질 페이지 수
	
	
	public Paging() {
		super();
	}
	
	public long getRows() {
		return rows;
	}
	public void setRows(long rows) {
		this.rows = rows;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getStartPage() {
		return startPage;
	}
	public void setStartPage(long startPage) {
		this.startPage = startPage;
	}
	public long getEndPage() {
		return endPage;
	}
	public void setEndPage(long endPage) {
		this.endPage = endPage;
	}
	public long getPageScale() {
		return pageScale;
	}
	public void setPageScale(long pageScale) {
		this.pageScale = pageScale;
	}
	
    
}


