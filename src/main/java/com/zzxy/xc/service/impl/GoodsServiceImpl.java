package com.zzxy.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.GoodsDao;
import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.service.GoodsService;
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


}
