package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Shopping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShoppingDao {

    @Select("select * from xc_shopping where id=#{id}")
    Shopping findShoppingById(Integer id);

}
