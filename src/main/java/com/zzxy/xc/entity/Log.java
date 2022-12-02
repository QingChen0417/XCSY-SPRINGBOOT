package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

//日志类
@Data
public class Log implements Serializable{
	private static final long serialVersionUID = -1472245586564106900L;
	
	private Integer id;//ID
	private String username;//用户姓名
	private String operation;//操作
	private String method;//方法
	private String params;//参数
	private Long time;//执行时间
	private String ip;//IP地址
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdTime;//创建时间
}
