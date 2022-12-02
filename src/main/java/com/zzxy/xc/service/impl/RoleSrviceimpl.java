package com.zzxy.xc.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzxy.common.entity.PageProperties;
import com.zzxy.common.entity.Pagination;
import com.zzxy.common.util.Assert;
import com.zzxy.common.util.ShiroUtil;
import com.zzxy.xc.dao.RoleDao;
import com.zzxy.xc.dao.RoleMenuDao;
import com.zzxy.xc.dao.UserRoleDao;
import com.zzxy.xc.entity.Role;
import com.zzxy.xc.service.RoleService;
import com.zzxy.xc.vo.RoleMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//角色业务层
@Service
public class RoleSrviceimpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PageProperties pp;

    public Pagination findRole(String name, Integer pageSize, Integer curPage) {
        Assert.isEmpty(pageSize==null||curPage==null,"请选择当前页码或每页条数!");
        pageSize = pageSize ==0 ? pp.getPageSize() : pageSize;
        Page<Role> page = PageHelper.startPage(curPage,pageSize);
        List<Role> list = roleDao.findRole(name);
        Pagination pageObj = new Pagination(curPage, (int)page.getTotal(), pageSize);
        pageObj.setPageData(list);
        return pageObj;
    }

    /**
     * 添加角色
     * @param role
     * @param ids
     * @return
     */
    public Integer insertRole(Role role, Integer[] ids) {
        //1.验证角色参数
        Assert.isEmpty(role==null|| role.getName()==null || role.getName().equals(""), "请填写角色名！");
        Assert.isEmpty(ids==null|| ids.length==0, "必须为角色分配权限");
        role.setCreatedUser(ShiroUtil.getUsername());
        //2.验证角色名是否存在
        Role r = roleDao.findroleByName(role.getName());
        Assert.isEmpty(r!=null,"角色名已存在！");
        //3.插入角色
        Integer rows = roleDao.insertRole(role);
        Assert.isEmpty(rows==0, "角色添加失败！");
        //4.插入角色和菜单的关系数据
        roleMenuDao.insertRoleById(role.getId(), ids);
        return rows;
    }
    /**
     * 删除角色
     * **/
    public Integer deleteRoleById(Integer id) {
        Assert.isEmpty(id==null||id == 0,"请选择要删除的对象！");
        roleMenuDao.deleteRoleMenuByMenuId(id);
        userRoleDao.deteleuserRoleByRoleId(id);
        int rows=roleDao.deleteRoleById(id);
        //3,验证结果
        Assert.isEmpty(rows==0, "角色不存在或以被删除！");
        return rows;
    }

    public RoleMenuVO findRoleMenuIds(Integer id) {
        Assert.isEmpty(id==null|| id==0, "请选择要修改的角色！");

        RoleMenuVO vo = roleDao.findRoleMenuIds(id);
        Assert.isEmpty(vo==null, "角色不存在！");
        return vo;
    }

    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }

    public Integer updateRoleById(Role role,RoleMenuVO vo) {
        Assert.isEmpty(vo==null||vo.getId()==null, "请选择要修改的角色！");
        vo.setModifiedUser(ShiroUtil.getUsername());
        //结果角色查找菜单的关系数据
        roleMenuDao.deleteRoleMenuByRoleId(vo.getId());
        roleMenuDao.insertRoleById(vo.getId(),vo.getMenuIds().toArray(new Integer[] {}));
        int n = roleDao.updateRoleById(vo);
        Assert.isEmpty(n==0, "修改失败！");
        return n;
    }
}
