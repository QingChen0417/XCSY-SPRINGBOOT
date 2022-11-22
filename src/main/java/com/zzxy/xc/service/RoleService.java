package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Role;
import com.zzxy.xc.vo.RoleMenuVO;

public interface RoleService {

    Pagination findRole(String name, Integer pageSize, Integer curPage);

    Integer insertRole(Role role, Integer[] Ids);

    Integer deleteRoleById(Integer id);

    /**
     * 根据角色修改菜单数据
     * @param vo
     * @return
     */
    Integer updateRoleById(RoleMenuVO vo);

    RoleMenuVO findRoleMenuIds(Integer id);
}
