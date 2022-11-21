package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//商品类别类
@Data
public class Category implements Serializable {
	private static final long serialVersionUID = -8366069114564459149L;
	
	private Integer id;//商品ID
	private String name;//商品名
	private Integer parentid;//
	private Integer state;//商品状态
	private Integer sort;//商品分类
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	private Date modifiedTime;//变质时间
	private String modifiedUser;//修改的用户
}