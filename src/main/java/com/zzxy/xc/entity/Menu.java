package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//菜单类
@Data
public class Menu implements Serializable{
	/**
	 * 重写序列化
	 */
	private static final long serialVersionUID = 2265300598541792836L;

	private Integer id;//菜单id
	private String name;//菜单名称
	private String url;//菜单url: log/doFindPageObjects
	private Integer type;//菜单类型(两种:按钮，普通菜单)
	private Integer sort;//排序型号
	private String note;//备注
	private Integer parentId;//上级菜单id
	private String permission;//菜单对应的权限标识(sys:log:delete)
	private Date createdTime;//创建时间
	private Date modifiedTime;//修改时间
	private String createdUser;//创建用户
	private String modifiedUser;//修改用户

}
