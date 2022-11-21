package com.zzxy.xc.service;

import com.zzxy.common.entity.Pagination;

public interface GoodsService {


    Pagination findGoods(String name, Integer curPage, Integer pageSize);

}
