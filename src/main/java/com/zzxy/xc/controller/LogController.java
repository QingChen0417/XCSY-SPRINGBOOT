package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private  LogService service;
	
	@RequestMapping("findLogObjects")
	public JsonResult findLogObjects(String username,@RequestParam(defaultValue = "4") Integer pageSize,@RequestParam(defaultValue = "1") Integer curPage) {
		Pagination pageObj = service.findLogService(username,pageSize,curPage);
		return new JsonResult(pageObj);
	}
	@RequestMapping("deleteLog")
	public JsonResult findLogDelete(@RequestParam("ids[]") Integer[] ids){
		int n = service.doDeleteLog(ids);
		return new JsonResult("成功删除"+n+"条数据！");
	}
}
