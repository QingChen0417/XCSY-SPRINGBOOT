package com.zzxy.xc.controller;

import com.zzxy.common.entity.JsonResult;
import com.zzxy.xc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping("findMemberZtree")
    public JsonResult findMemberZtree() {
        return new JsonResult(service.findMemberZtree());
    }

}
