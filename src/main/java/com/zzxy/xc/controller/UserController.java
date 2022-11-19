package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
