package com.zzxy.xc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("{module}/{page}")
	public String doModuleUI(@PathVariable("page") String page) {
		return "sys/"+page;
	}

	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}}
