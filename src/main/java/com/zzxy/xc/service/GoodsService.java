package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;
import com.zzxy.xc.entity.Goods;
import com.zzxy.xc.vo.GoodsCateVo;

public interface GoodsService {


    Pagination findGoods(String name, Integer curPage, Integer pageSize);

    Integer updateValid(Integer id, Integer state);

    Integer saveGoods(Goods goods);

    GoodsCateVo findGoodsCateVo(Integer id);

    Integer updateGoods(Goods goods);
}
