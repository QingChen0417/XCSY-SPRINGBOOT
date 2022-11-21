package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;

public interface RoleService {

    Pagination findRole(String name, Integer pageSize, Integer curPage);
}
