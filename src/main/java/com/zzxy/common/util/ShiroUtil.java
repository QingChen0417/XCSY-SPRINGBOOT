package com.zzxy.common.util;

import com.zzxy.xc.entity.User;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

	/*
	 * 在Shiro中管理登录对象的类型是
	 * Subject
	 */
	
	/**
	 * 获取登录对象
	 * @return
	 */
	public static User getLoginUser() {
		//(SysUser)SecurityUtils.getSubject(): 获取subject实现对象
		//Subject: 管理主体对象即登录对象
		//subject.getPrincipal();获取登录对象
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
	
	/**
	 * 获取登录的用户名
	 * @return
	 */
	public static String getUsername() {
		return getLoginUser().getUsername();
	}
}
