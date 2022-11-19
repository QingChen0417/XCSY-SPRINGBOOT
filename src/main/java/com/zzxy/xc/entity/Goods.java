package com.zzxy.xc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//商品类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
	private static final long serialVersionUID = 8327274088915070369L;
	
	private Integer id;//商品ID
	private Integer cateid;//类别id
	private String name;//商品名
	private String subtitle;//商品副标题
	private String imgUrl;//商品图片
	private Double price;//价格
	private Integer stock;//库存
	private Integer state;//状态
	private Date createdTime;//创建时间
	private String createdUser;//创建的用户
	private Date modifiedTime;//修改时间
	private String modifiedUser;//修改的用户

}
