package org.zerock.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	public void setPage(int page) {	// 페이지 번호는 강제로 1페이지로 지정함
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {	// 	|| (or 연산자)
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	public int getPage() {
		return page;
	}
	
	//method for SQL Mapper
	public int getPageStart() { // 시작 페이지를 가져오는 method 로직
		return(this.page -1) * perPageNum;
	}
	
	//method for SQL Mapper
	public int getPerPageNum() {
		return this.perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
}
