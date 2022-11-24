package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.xc.entity.Menu;
import com.zzxy.xc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("doDeleteMenu")
    public JsonResult doDeleteMenu(Integer menuId){
        return new JsonResult(service.deleteMenuById(menuId));
    }
    @RequestMapping("findZtreeMenuNodes")
    private JsonResult findZtreeMenuNodes() {
        return new JsonResult(service.findZtreeMenuNodes());
    }
    @RequestMapping("saveMenu")
    private JsonResult saveMenu(Menu menu) {
        JsonResult  jr = new  JsonResult(service.insertMenu(menu));
        jr.setMessage("添加成功！");
        return jr;
    }
    @RequestMapping("updateMenu")
    public JsonResult updataMenu(Menu menu) {
        JsonResult  jr = new  JsonResult(service.updateMenu(menu));
        jr.setMessage("修改成功！");
        return jr;
    }
}
