package com.zzxy.xc.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao {

    /**
     * 通过角色id删除用户角色关系数据
     * @param roleId
     * @return
     * */
    @Delete("delete from xc_users_roles where role_id=#{roleId}")
    Integer deteleuserRoleByRoleId(Integer id);
}
