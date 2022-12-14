package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//会员信息实体类
@Data
public class Member implements Serializable{
	private static final long serialVersionUID = 6087253410364854719L;
	private Integer id;//会员ID
	private String name;//会员名
	private Integer parentId;//上级id
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	private Date modifiedTime;//变质时间
	private String modifiedUser;//修改的用户
}
