package com.zzxy.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.LogDao;
import com.zzxy.xc.entity.Log;
import com.zzxy.xc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceimpl implements LogService{

	@Autowired
	private LogDao dao;
	
	@Autowired
	private PageProperties pp;
	
	public Pagination findLogService(String username, Integer pageSize, Integer curPage) {
		pageSize = pageSize ==0 ? pp.getPageSize() : pageSize;
		Page<Log> page = PageHelper.startPage(curPage,pageSize);
		System.out.println(page);
		List<Log> list = dao.findLogObject(username);
		Pagination pageObj = new Pagination(curPage, (int)page.getTotal(), pageSize);
		pageObj.setPageData(list);
		return pageObj;
	}
	public int doDeleteLog(Integer[] ids) {
		Assert.isEmpty(ids == null|| ids.length==0,"未选择数据！");
		int n = dao.doDeleteByIds(ids);
		Assert.isEmpty(n==0,"数据已被删除！");
		return n;
	}
}
