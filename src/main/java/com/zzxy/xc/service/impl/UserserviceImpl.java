package com.zzxy.xc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.annotation.RequirdLog;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.xc.dao.UserDao;
import com.zzxy.xc.dao.UserRoleDao;
import com.zzxy.xc.dao.UsermemberDao;
import com.zzxy.xc.entity.User;
import com.zzxy.xc.entity.UserInfo;
import com.zzxy.xc.vo.UsermemberVo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzxy.xc.service.UserService;

import java.util.List;
import java.util.UUID;

//用户业务接口实现类
@Service
public class UserserviceImpl implements UserService {


    @Autowired
    private UserDao dao;

    @Autowired
    private UsermemberDao umDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PageProperties pp;

    @RequirdLog("查询用户")
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

    @RequirdLog("添加用户")
    public void saveUser(User user, Integer[] roleIds) {
        Assert.isEmpty(user == null || user.getUsername() == null || user.getUsername().equals(""), "请输入用户名");
        Assert.isEmpty(roleIds == null || roleIds.length == 0, "请选择角色");
        String salt = UUID.randomUUID().toString();
        SimpleHash sh = new SimpleHash("MD5", user.getPassword(), salt, 1);
        String password = sh.toHex();
        user.setSalt(salt);
        user.setPassword(password);
        User u = dao.findUserByName(user.getUsername());//查找用户是否存在
        Assert.isEmpty(u != null, "用户名已存在");
        Integer n = dao.insertUser(user);
        Assert.isEmpty(n == 0, "添加失败");
        userRoleDao.insertUserRole(user.getId(), roleIds);
    }

    public List<Integer> findRoleByUserId(Integer userId) {
        Assert.isEmpty(userId == null || userId == 0, "请选择要修改的用户");
        return dao.findRoleByUserId(userId);
    }

    public void updateUser(User user, Integer[] roleIds) {
        Assert.isEmpty(roleIds == null || roleIds.length == 0, "请选择角色");
        //user.setModifiedUser(ShiroUtil.getUsername());
        Integer n = dao.updateUser(user);
        Assert.isEmpty(n == 0, "修改失败");
        userRoleDao.deleteRoleUserId(user.getId());
        userRoleDao.insertUserRole(user.getId(), roleIds);
    }

    public UserInfo findUserInfoByUserId(Integer id) {
        return dao.findUserInfoByUserId(id);
    }
}
