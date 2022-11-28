package com.zzxy.xc.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleDao {

    /**
     * 通过角色id删除用户角色关系数据
     * @param roleId
     * @return
     * */
    @Delete("delete from xc_users_roles where role_id=#{roleId}")
    Integer deteleuserRoleByRoleId(Integer roleId);

    /**
     * 添加用户角色关系数据
     * @param id
     * @param roleIds
     */
    void insertUserRole(@Param("id") Integer id,@Param("roleIds") Integer[] roleIds);

    /**
     * 通过用户id删除用户角色关系数据
     * @param id
     */
    @Delete("delete from xc_users_roles where user_id=#{id}")
    void deleteRoleUserId(Integer id);
}
