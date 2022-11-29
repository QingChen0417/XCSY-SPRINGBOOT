package com.zzxy.xc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shopping implements Serializable {
    private Integer id;//地址ID
    private Integer userid;//用户ID
    private String name;//用户姓名
    private String phone;//电话号码
    private String province;//省
    private String city;//市
    private String strict;//区
    private String address;//详细地址
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;//创建时间
    private String createdUser;//创建的用户
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;//修改时间
    private String modifiedUser;//修改的用户
}
