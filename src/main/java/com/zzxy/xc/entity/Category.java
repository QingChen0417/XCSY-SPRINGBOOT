package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//商品类别类
@Data
public class Category implements Serializable {
	private static final long serialVersionUID = -8366069114564459149L;
	
	private Integer id;//类别ID
	private String name;//类别名
	private Integer parentId;//上级分类Id
	private String state;//状态
	private Integer sort;//排序型号
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	private Date modifiedTime;//变质时间
	private String modifiedUser;//修改的用户
}
