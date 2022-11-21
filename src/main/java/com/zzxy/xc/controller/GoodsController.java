package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired(required=false)
    private GoodsService service;

    @RequestMapping("findGoods")
    public JsonResult findGoods(String name,
                                @RequestParam(defaultValue = "1") Integer curPage,
                                @RequestParam(defaultValue = "0") Integer pageSize){
        Pagination pagina = service.findGoods(name, curPage, pageSize);
        return new JsonResult(pagina);
    }

    @RequestMapping("updateValid")
    public JsonResult updateValid(Integer id, Integer state){
        service.updateValid(id,state);
        return new JsonResult("修改成功");
    }
    @RequestMapping("saveGoods")
    public JsonResult saveGoods(Goods goods){
        service.saveGoods(goods);
        return new JsonResult("添加成功");
    }
}
