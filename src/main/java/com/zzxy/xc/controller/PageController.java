package com.zzxy.xc.controller;

import com.zzxy.common.util.ShiroUtil;
import com.zzxy.xc.entity.User;
import com.zzxy.xc.entity.UserInfo;
import com.zzxy.xc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PageController {

	@Autowired
	private UserService userService;

	@RequestMapping("doIndexUI")
	public String doIndexUI(Map<String, Object> map) {
		User user = ShiroUtil.getLoginUser();
		map.put("user", user);
		UserInfo ui = userService.findUserInfoByUserId(user.getId());
		map.put("userInfo", ui);
		return "starter";
	}

	//"{module}/{page}" : 可以统一接受访问路径
	//参数需加@PathVariable()注解
	@RequestMapping("{module}/{page}")
	public String doModuleUI(@PathVariable("module") String module, @PathVariable("page") String page, Map<String, Object> map) {
		map.put("user", ShiroUtil.getUsername());
		return module + "/" + page;
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

	@RequestMapping("upLoadUI")
	public String upLoadUI() {
		return "upload";
	}

	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
}
