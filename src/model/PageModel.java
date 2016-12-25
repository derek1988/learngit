package model;

import java.util.List;

public class PageModel {
	private List list;
	private int pageSize;
	private int totalPages;
	public int getTotalPages() {
		return (totalRecords+pageSize-1)/pageSize;
	}
	public void setTotalPages(){
		totalPages=(totalRecords+pageSize-1)/pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo; 
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	private int pageNo;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	private int totalRecords;
	
	/**
	 * 获取首页
	 * @return
	 */
	public int getTopPageNo(){
		return 1;
	}
	/**
	 * 获取前一页
	 * @return
	 */
	public int getPrePageNo(){
		if(pageNo<=1){
			return 1;
		}
		return pageNo-1;
	}
	/**
	 * 获取后一页
	 * @return
	 */
	public int getNextPageNo(){
		if(pageNo>=totalPages){
			return totalPages;
		}
		return pageNo+1;
	}
	/**
	 * 获取最后一页
	 * @return
	 */
	public int getLastPageNo(){
		return totalPages;
	}
}
