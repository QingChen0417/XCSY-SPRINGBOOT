package com.zzxy.xc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.zzxy.xc.entity.Member;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsermemberVo implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private Member member;
    private Integer valid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    private String createdUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;
    private String modifiedUser;
}
