package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.vo.UserGoodsShoppingVo;

public interface OrderService {

    Pagination findOrder(String orderid, Integer curPage, Integer pageSize);

    int deleteOrderByIds(Integer[] ids);
}
