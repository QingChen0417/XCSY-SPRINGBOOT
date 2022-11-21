package com.zzxy.xc.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.RoleDao;
import com.zzxy.xc.entity.Role;
import com.zzxy.xc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//角色业务层
@Service
public class RoleSrviceimpl implements RoleService {

    @Autowired
    private RoleDao roledao;

    @Autowired
    private PageProperties pp;

    public Pagination findRole(String name, Integer pageSize, Integer curPage) {
        Assert.isEmpty(pageSize==null||curPage==null,"请选择当前页码或每页条数!");
        pageSize = pageSize ==0 ? pp.getPageSize() : pageSize;
        Page<Role> page = PageHelper.startPage(curPage,pageSize);
        List<Role> list = roledao.findRole(name);
        Pagination pageObj = new Pagination(curPage, (int)page.getTotal(), pageSize);
        pageObj.setPageData(list);
        return pageObj;
    }
}
