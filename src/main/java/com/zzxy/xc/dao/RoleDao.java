package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Role;
import com.zzxy.xc.vo.RoleMenuVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//角色dao层
@Mapper
public interface RoleDao {
    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Role> findRole(String name);

    int insertRole(Role role);

    @Select("select id,name from xc_roles where name=#{name}")
    Role findroleByName(String name);

    /**
     * 根据id删除角色
     * @return
     * */
    @Delete("delete from xc_roles where id = #{id}")
    int deleteRoleById(Integer id);

    /**
     * 根据角色查找菜单
     * @param id
     * @return
     */
    RoleMenuVO findRoleMenuIds(Integer id);

    /**
     * 根据角色id修改角色菜单关系数据
     * */
    Integer updateRoleById(RoleMenuVO vo);

}
