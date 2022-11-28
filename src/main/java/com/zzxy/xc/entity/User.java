package com.zzxy.xc.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//用户类
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1622763499659883435L;
	private Integer id;
	private String username;
	private String password;
	private String salt;
	private String email;
	private String phone;
	private Integer valid = 1;
	private Integer memberId;
	private Date createdTime;
	private String createdUser;
	private Date modifiedTime;
	private String modifiedUser;
	
}
