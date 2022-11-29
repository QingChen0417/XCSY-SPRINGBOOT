package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.User;

import java.util.List;

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

    /**
     * 添加用户和用户角色
     * @param user
     * @param roleIds
     */
    void saveUser(User user, Integer[] roleIds);

    /**
     * 通过用户id查找角色
     * @param userId
     * @return
     */
    List<Integer> findRoleByUserId(Integer userId);

    /**
     * 修改用户信息和用户角色信息
     * @param user
     * @param roleIds
     */
    void updateUser(User user, Integer[] roleIds);
}
