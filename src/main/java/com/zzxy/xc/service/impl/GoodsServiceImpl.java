package com.zzxy.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.GoodsDao;
import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.service.GoodsService;
import com.zzxy.xc.vo.GoodsCateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao dao;

    @Autowired
    private PageProperties pp;

    public Pagination findGoods(String name, Integer curPage, Integer pageSize) {
        pageSize = pageSize == 0 || pageSize == null ? pp.getPageSize() : pageSize;
        Page<Goods> page = PageHelper.startPage(curPage, pageSize);
        List<Goods> list =  dao.findGoods(name);
        Pagination pageObj = new Pagination(curPage, (int)page.getTotal(), pageSize);
        pageObj.setPageData(list);
        return pageObj;
    }

    public Integer updateValid(Integer id, Integer state) {
        Assert.isEmpty(id == 0 || id == null, "请选择要修改的用户");
        Assert.isEmpty(state == null, "操作有误");
        Integer n = dao.updateValid(id,state);
        return n;
    }

    public Integer saveGoods(Goods goods) {
        Assert.isEmpty(goods == null || goods.getName() == null, "请填写商品信息");
        Integer n = dao.saveGoods(goods);
        Assert.isEmpty(n == 0, "添加失败");
        return n;
    }

    public GoodsCateVo findGoodsCateVo(Integer id) {
        Assert.isEmpty(id == null || id == 0 , "请选择要修改的商品");
        GoodsCateVo goodsCateVo= dao.findGoodsCateVo(id);
        return goodsCateVo;
    }

    public Integer updateGoods(Goods goods) {
        Assert.isEmpty(goods == null || goods.getId() == 0 || goods.getId() == null, "请选择要修改的商品");
        int n = dao.updateGoods(goods);
        Assert.isEmpty(n == 0,"修改失败");
        return n;
    }


}
