package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Goods;

public interface GoodsService {


    Pagination findGoods(String name, Integer curPage, Integer pageSize);

    Integer updateValid(Integer id, Integer state);

    Integer saveGoods(Goods goods);
}
