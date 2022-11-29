package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Order;
import com.zzxy.xc.vo.UserGoodsShoppingVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    /**
     * 加载订单信息
     * @param orderid
     * @return
     */
    List<UserGoodsShoppingVo> findOrder(String orderid);

    /**
     * 根据id删除订单数据
     * @param ids
     * @return
     */
    int deleteOrderByIds(Integer[] ids);
}
