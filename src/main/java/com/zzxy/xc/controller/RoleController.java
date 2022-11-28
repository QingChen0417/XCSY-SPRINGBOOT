package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.common.entity.Pagination;

import com.zzxy.xc.entity.Role;
import com.zzxy.xc.service.RoleService;
import com.zzxy.xc.vo.RoleMenuVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//角色控制层
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleservice;

    @RequestMapping("findRole")
    public JsonResult findRole(String name,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "1") Integer curPage) {
        Pagination pagination = roleservice.findRole(name,pageSize,curPage);
        return new JsonResult(pagination);
    }
    /**
     * 添加角色（给角色授权）
     * */
    @RequestMapping("saveRole")
    public JsonResult saveRole(Role role,@RequestParam("menuIds[]") Integer[] menuIds){
        roleservice.insertRole(role,menuIds);
        return new JsonResult("添加成功！");
    }
    /**
     * 通过id删除角色
     * @param id
     * @return
     * */
    @RequestMapping("deleteRole")
    public JsonResult deleteRoleById(Integer id) {
        roleservice.deleteRoleById(id);
        return new JsonResult("删除成功！");
    }
    @RequestMapping("findRoleMenuIdsByRoleId")
    public JsonResult findRoleMenuIdsByRoleId(Integer id) {
        RoleMenuVO vo = roleservice.findRoleMenuIds(id);
        return new JsonResult(vo);
    }

   @RequestMapping("updateRoleById")
   public JsonResult updataRoleById(RoleMenuVO vo) {
       roleservice.updateRoleById(vo);
       return new JsonResult("修改成功！");
   }

   @RequestMapping("findAllRole")
   public JsonResult findAllRole() {
        List<Role> list = roleservice.findAllRole();
        return new JsonResult(list);
   }

}
