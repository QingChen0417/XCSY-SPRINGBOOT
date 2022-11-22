package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Role;
import com.zzxy.xc.vo.SysRoleMenuVO;

public interface RoleService {

    Pagination findRole(String name, Integer pageSize, Integer curPage);

    Integer insertRole(Role role, Integer[] Ids);

    Integer deleteRoleById(Integer id);

    /**
     * 根据角色修改菜单数据
     * @param vo
     * @return
     */
    Integer updateRoleById(SysRoleMenuVO vo);

    SysRoleMenuVO findRoleMenuIds(Integer id);
}
