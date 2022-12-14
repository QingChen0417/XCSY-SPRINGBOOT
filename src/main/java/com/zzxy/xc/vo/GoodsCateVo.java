package com.zzxy.xc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzxy.xc.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCateVo implements Serializable {
    private Integer id;//商品ID
    private Category category;//类别对象
    private String name;//商品名
    private String subtitle;//商品副标题
    private String imgUrl;//商品图片
    private Double price;//价格
    private Integer stock;//库存
    private Integer state;//状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;//创建时间
    private String createdUser;//创建的用户
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;//修改时间
    private String modifiedUser;//修改的用户
}
