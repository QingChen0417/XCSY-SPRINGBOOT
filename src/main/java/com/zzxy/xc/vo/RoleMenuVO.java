package com.zzxy.xc.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改的用户
}
