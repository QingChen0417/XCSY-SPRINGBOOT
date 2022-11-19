package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

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
	private Integer time;//执行时间
	private String ip;//IP地址
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	private Date modifiedTime;//变质时间
	private String modifiedUser;//修改的用户
}
