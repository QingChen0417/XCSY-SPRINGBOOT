package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.xc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService service;

    @RequestMapping("doFindMenus")
    private JsonResult doFindObjects() {
        return new JsonResult (service.findObjects());
    }
}
