package com.zzxy.xc.entity;

import lombok.Data;

//用户详细信息类
@Data
public class UserInfo {
    private Integer id;//id
    private Integer userId;//用户id
    private String headImg;//用户头像地址
    private String sex;//性别
    private Integer age;//年龄
    private String residence;//居住地
}
