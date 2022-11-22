package com.zzxy.xc.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class RoleMenuVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2781402317574820808L;
	/**角色id*/
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;

}
