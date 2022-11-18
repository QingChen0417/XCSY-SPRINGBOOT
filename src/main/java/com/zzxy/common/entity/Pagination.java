package com.zzxy.common.entity;

import lombok.Data;

import java.util.List;

//分页对象
@Data
public class Pagination {
	private int curPage;//当前页
	private int pageSize;//每页条数
	private int countSize;//总条数
	private int countPage;//总页数
	private List<?> pageData;//分页数据
	  /**
     * 通过此方法实现分页查询操作
     * @param name 基于条件查询时的参数名
     * @param pageCurrent 当前的页码值
     * @return 当前页记录+分页信息
     */

	public Pagination(int curPage, int countSize, int pageSize) {
		/*
		 * this.countPage = countSize % pageSize == 0 ? countSize % pageSize : countSize
		 * % pageSize +1;
		 */
		this.countPage =(countSize + pageSize -1) / pageSize;
		this.countSize =countSize;
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
		this.pageSize = this.pageSize >= 50 ? 50 : this.pageSize;
		this.curPage = curPage < 1 ? 1 :curPage;
		this.curPage = this.curPage > this.countPage ? this.countPage : this.curPage;
	}
}
