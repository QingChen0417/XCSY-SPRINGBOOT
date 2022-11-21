package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//角色dao层
@Mapper
public interface RoleDao {

    List<Role> findRole(String name);


}
