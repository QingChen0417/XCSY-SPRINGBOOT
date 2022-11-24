package com.zzxy.xc.dao;

import com.zzxy.common.entity.Node;
import com.zzxy.xc.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//菜单dao层
@Mapper
public interface MenuDao {
    /**
     * 查找所有数据
     * */
    List<Map<String, Object>> findObjects();

    /**
     * 根据父id查找子菜单的数量
     * @param menuId
     * @return
     */
    Integer getCountChildByMenuId(Integer menuId);

    /**
     * 根据菜单id删除菜单
     * @param menuId
     * @return
     */
    Integer deleteMenuById(Integer menuId);

    /**
     * 查找菜单id，菜单名和父菜单id
     * @return
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 插入菜单数据
     * @param menu
     * @return
     */
    Integer insertMenu(Menu menu);

    /**
     * 通过菜单id修改菜单状态
     * @param menu
     * @return
     */
    Integer updateMenu(Menu menu);
}
