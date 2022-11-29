package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.xc.entity.Category;
import com.zzxy.xc.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping("doFindCategory")
    public JsonResult doFindObjects() {
        return new JsonResult (service.findObjects());
    }
    @RequestMapping("findZtreeCategoryNodes")
    private JsonResult findZtreeCategoryNodes() {
        return new JsonResult(service.findZtreeCategoryCnodes());
    }
    @RequestMapping("saveCategory")
    private JsonResult saveCategory(Category category) {
        JsonResult  jr = new  JsonResult(service.insertCategory(category));
        jr.setMessage("添加成功！");
        return jr;
    }
    @RequestMapping("updateCategory")
    public JsonResult updateCategory(Category category) {
        JsonResult  jr = new  JsonResult(service.updateCategory(category));
        jr.setMessage("修改成功！");
        return jr;
    }
    @RequestMapping("doDeleteCategory")
    public JsonResult doDeleteCategoryById(Integer menuId) {
        return new JsonResult(service.doDeleteCategoryById(menuId));
    }

}
