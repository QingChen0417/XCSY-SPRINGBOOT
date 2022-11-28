package com.zzxy.xc.service;

import com.zzxy.common.entity.Node;
import com.zzxy.xc.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {

    /**
     * 查看所有菜单数据
     * @return
     */
    public List<Map<String,Object>> findObjects();

    /**
     * 根据id删除菜单
     * @param menuId
     * @return
     */
    Integer deleteMenuById(Integer menuId);

    /**
     * 展开所有上级菜单
     * @return
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    Integer insertMenu(Menu menu);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    Integer updateMenu(Menu menu);
}
