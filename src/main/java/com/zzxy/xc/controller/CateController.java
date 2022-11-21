package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.xc.entity.Category;
import com.zzxy.xc.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cate")
public class CateController {

    @Autowired(required=false)
    private CateService service;

    @RequestMapping("findCateZtree")
    public JsonResult findCateZtree(){
        List<Category> list = service.findCateZtree();
        return new JsonResult(list);
    }
}
