package com.zzxy.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.UserDao;
import com.zzxy.xc.dao.UsermemberDao;
import com.zzxy.xc.entity.Log;
import com.zzxy.xc.vo.UsermemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzxy.xc.service.UserService;

import java.util.List;

//用户业务接口实现类
@Service
public
class UserserviceImpl implements UserService {


    @Autowired
    private UserDao dao;

    @Autowired
    private UsermemberDao umDao;

    @Autowired
    private PageProperties pp;

    public Pagination findUsermemberVo(String username, Integer curPage, Integer pageSize) {
        pageSize = pageSize ==0 ? pp.getPageSize() : pageSize;
        Page<UsermemberVo> page = PageHelper.startPage(curPage,pageSize);
        List<UsermemberVo> list = umDao.findUsermemberVo(username);
        Pagination pageObj = new Pagination(curPage, (int)page.getTotal(), pageSize);
        pageObj.setPageData(list);
        return pageObj;
    }

    public void updateValid(Integer id, Integer valid) {
        Assert.isEmpty(id == null || id == 0, "请选择要修改的用户");
        Integer n = dao.updateValid(id, valid);
        Assert.isEmpty(n == 0, "修改失败");
    }
}
