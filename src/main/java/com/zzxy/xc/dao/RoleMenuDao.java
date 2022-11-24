package com.zzxy.xc.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 权限和菜单的关系dao层
 * **/
@Mapper
public interface RoleMenuDao {

    /**
     * 通过菜单id删除角色信息
     * @param id
     * @return
     */
    Integer deleteRoleMenuByMenuId(Integer id) ;

    /**
     * 插入角色和菜单的关系数据
     * @param roleId
     * @param menuIds
     * @return
     */
    Integer insertRoleById(@Param("roleId")Integer roleId,@Param("menuIds")Integer[] menuIds);

    /**
     * 通过角色id删除角色菜单关系数据
     * @param roleId
     * @return
     * */
    @Delete("delete from xc_roles_menus where role_id=#{roleId}")
    Integer deleteRoleMenuByRoleId(Integer roleId);

    /**
     * 通过roleId所有菜单id
     * @param roleId
     * @return
     */
    @Select("select menu_Id from xc_roles_menus where role_id=#{roleId}")
    List<Integer> findMenuIdsByRoleId(Integer roleId);

}
