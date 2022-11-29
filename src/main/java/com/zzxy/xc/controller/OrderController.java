package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController{

    @Autowired
    private OrderService service;

    /**
     * 查询所有数据信息
     * @param orderid
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping("findOrder")
    public JsonResult findOrder(String orderid,
                                @RequestParam(defaultValue = "1") Integer curPage,
                                @RequestParam(defaultValue = "0") Integer pageSize){
        Pagination pagina = service.findOrder(orderid, curPage, pageSize);
        return new JsonResult(pagina);
    }

    /**
     * 根据id删除订单数据
     * @param ids
     * @return
     */
    @RequestMapping("deleteOrderByIds")
    public JsonResult deleteOrderByIds(@RequestParam("ids[]")Integer[] ids){
        int n = service.deleteOrderByIds(ids);
        return new JsonResult(n);
    }
}
