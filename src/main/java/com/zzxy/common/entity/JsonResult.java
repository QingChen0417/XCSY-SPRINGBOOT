package com.zzxy.common.entity;

import lombok.Data;

//响应结果类
@Data
public class JsonResult {
	private Integer state =1;//状态
	private Object data;//成功数据
	private String message;//异常文本描述
	public JsonResult(Throwable e) {
		state = 0;
		message =e.getMessage();
	}
	public JsonResult(Object data) {
		this.data =data;
	}

    public JsonResult() {

    }
}
