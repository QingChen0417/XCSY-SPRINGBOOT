package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;

//用户业务接口
public interface UserService {

    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @param curPage 当前页
     * @param pageSize 每页条数
     * @return
     */
    Pagination findUsermemberVo(String username, Integer curPage, Integer pageSize);
}
