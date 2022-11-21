package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//会员信息实体类
@Data
public class Members implements Serializable{
	private static final long serialVersionUID = 6087253410364854719L;
	private Integer id;//商品ID
	private String memberName;//成员名
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	private Date modifiedTime;//变质时间
	private String modifiedUser;//修改的用户
}
