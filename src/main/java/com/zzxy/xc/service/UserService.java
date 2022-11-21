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

    /**
     * 通过用户id修改用户账号状态
     * @param id 用户id
     * @param valid 用户状态
     */
    void updateValid(Integer id, Integer valid);
}
