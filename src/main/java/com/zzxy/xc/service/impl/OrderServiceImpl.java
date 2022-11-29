package com.zzxy.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.GoodsDao;
import com.zzxy.xc.dao.OrderDao;
import com.zzxy.xc.dao.ShoppingDao;
import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.entity.Order;
import com.zzxy.xc.service.OrderService;
import com.zzxy.xc.vo.UserGoodsShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;

    @Autowired
    private PageProperties pp;

    public Pagination findOrder(String orderid, Integer curPage, Integer pageSize) {
        pageSize = pageSize == 0 || pageSize == null ? pp.getPageSize() : pageSize;
        Page<Order> page = PageHelper.startPage(curPage, pageSize);
        List<UserGoodsShoppingVo> list =  dao.findOrder(orderid);
        System.out.println(list);
        Pagination pageObj = new Pagination(curPage, (int)page.getTotal(), pageSize);
        pageObj.setPageData(list);
        return pageObj;
    }

    public int deleteOrderByIds(Integer[] ids) {
        Assert.isEmpty(ids == null || ids.length == 0, "数据不存在或已被删除");
        int n = dao.deleteOrderByIds(ids);
        Assert.isEmpty(n == 0,"删除失败");
        return n;
    }

}
