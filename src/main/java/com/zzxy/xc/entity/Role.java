package com.zzxy.xc.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//角色类
@Data
public class Role implements Serializable {

	private static final long serialVersionUID = -1006150659798019587L;
	private Integer id;//ID
	private String name;//角色名
	private String note;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改的用户


}
