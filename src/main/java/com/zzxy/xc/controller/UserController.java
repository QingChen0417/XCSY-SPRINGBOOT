package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.User;
import com.zzxy.xc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//用户控制类
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findUsermemberVo")
    public JsonResult findUsermemberVo(String username, @RequestParam(defaultValue = "1") Integer curPage,@RequestParam(defaultValue = "5") Integer pageSize) {
        Pagination pageObj = userService.findUsermemberVo(username, curPage, pageSize);
        return new JsonResult(pageObj);
    }

    @RequestMapping("updateValid")
    public JsonResult updateValid(Integer id, Integer valid) {
        userService.updateValid(id, valid);
        return new JsonResult("修改成功");
    }

    @RequestMapping("saveUser")
    public JsonResult saveUser(User user,@RequestParam("roleIds[]") Integer[] roleIds) {
        userService.saveUser(user, roleIds);
        return new JsonResult("添加成功");
    }

    @RequestMapping("findRoleByUserId")
    public JsonResult findRoleByUserId(Integer userId) {
        List<Integer> roles = userService.findRoleByUserId(userId);
        return new JsonResult(roles);
    }

    @RequestMapping("updateUser")
    public JsonResult updateUser(User user,@RequestParam("roleIds[]") Integer[] roleIds) {
        userService.updateUser(user, roleIds);
        return new JsonResult("修改成功");
    }

    @RequestMapping("doLogin")
    public JsonResult doLogin(String username, String password, boolean isRememberMe) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        System.out.println(isRememberMe + "-------------");
        token.setRememberMe(isRememberMe);
        subject.login(token);
        return new JsonResult("登录成功");
    }
}
