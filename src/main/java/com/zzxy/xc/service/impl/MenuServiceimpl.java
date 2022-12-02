package com.zzxy.xc.service.impl;

import com.zzxy.common.entity.Node;
import com.zzxy.common.util.Assert;
import com.zzxy.common.util.ShiroUtil;
import com.zzxy.xc.dao.MenuDao;
import com.zzxy.xc.dao.RoleMenuDao;
import com.zzxy.xc.entity.Menu;
import com.zzxy.xc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceimpl implements MenuService {

    @Autowired
    private MenuDao dao;

    @Autowired
    private RoleMenuDao rmDao;

    public List<Map<String, Object>> findObjects() {
        List<Map<String,Object>> list = dao.findObjects();
        Assert.isEmpty(list == null || list.size() == 0, "菜单不存在");
        return list;
    }
    public Integer deleteMenuById(Integer menuId) {
        //查看当前菜单id的子菜单数量
        Integer n = dao.getCountChildByMenuId(menuId);
        //如果子菜单数量大于0则直接抛出异常
        Assert.isEmpty(n>0,"有子菜单不允许删除！");
        //如果子菜单数量等于0则删除菜单与权限的关系数据
        rmDao.deleteRoleMenuByMenuId(menuId);
        //之后根据该id删除菜单
        Integer t =dao.deleteMenuById(menuId);
        Assert.isEmpty(t==0, "菜单可能已被删除！");
        return t;
    }
    public List<Node> findZtreeMenuNodes() {
        List<Node> list=dao.findZtreeMenuNodes();
        Assert.isEmpty(list==null||list.size()==0,"菜单不存在！");
        return list;
    }
    public Integer insertMenu(Menu menu) {
        Assert.isEmpty(menu==null||menu.getName()==null,"菜单不存在！");
        menu.setCreatedUser(ShiroUtil.getUsername());
        Integer n = dao.insertMenu(menu);
        return n;
    }
    public Integer updateMenu(Menu menu) {
        Assert.isEmpty(menu==null||menu.getName()==null, "请填写数据！");
        menu.setCreatedUser(ShiroUtil.getUsername());
        Integer n = dao.updateMenu(menu);
        Assert.isEmpty(n==0, "菜单修改失败或者数据不存在！");
        return n;
    }

}
