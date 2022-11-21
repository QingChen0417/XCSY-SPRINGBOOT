package com.zzxy.xc.service.impl;

import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.CateDao;
import com.zzxy.xc.entity.Category;
import com.zzxy.xc.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImpl implements CateService {

    @Autowired
    private CateDao dao;

    public List<Category> findCateZtree() {
        List<Category> list = dao.findCateZtree();
        Assert.isEmpty(list == null, "分类信息不存在");
        return list;
    }
}
