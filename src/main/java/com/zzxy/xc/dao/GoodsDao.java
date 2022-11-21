package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {

    List<Goods> findGoods(String name);

}
