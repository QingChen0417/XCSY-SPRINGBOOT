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
public class Order implements Serializable {

    private Integer id;//订单ID
    private String orderid;//订单编号
    private Integer userid;//用户ID
    private Integer goodsid;//商品ID
    private Integer shoppingid;//收货地址ID
    private Integer payment;//付款金额
    private String paymenttype;//付款方式
    private Integer postage;//邮费
    private Integer state;//状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date paymenttime;//付款时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendtime;//商品发货时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endtime;//商品到达时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;//创建时间
    private String createdUser;//创建的用户
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;//修改时间
    private String modifiedUser;//修改的用户
}
