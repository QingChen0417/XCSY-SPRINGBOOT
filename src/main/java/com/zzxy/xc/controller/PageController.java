package com.zzxy.xc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}

	//"{module}/{page}" : 可以统一接受访问路径
	//参数需加@PathVariable()注解
	@RequestMapping("{module}/{page}")
	public String doModuleUI(@PathVariable("page") String page) {
		return "sys/"+page;
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

}
