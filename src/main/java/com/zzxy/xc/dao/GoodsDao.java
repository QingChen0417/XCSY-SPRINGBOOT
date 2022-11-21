package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    List<Goods> findGoods(String name);

    @Update("update xc_goods set state=#{state} where id=#{id}")
    Integer updateValid(@Param("id")Integer id, @Param("state")Integer state);

    Integer saveGoods(Goods goods);
}
