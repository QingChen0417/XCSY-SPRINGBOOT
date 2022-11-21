package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;

import com.zzxy.xc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//角色控制层
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleservice;

    @RequestMapping("findRole")
    public JsonResult findRole(String name,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "1") Integer curPage) {
        Pagination pagination = roleservice.findRole(name,pageSize,curPage);
        return new JsonResult(pagination);
    }
}
