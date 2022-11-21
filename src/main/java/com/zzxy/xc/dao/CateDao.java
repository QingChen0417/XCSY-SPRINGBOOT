package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CateDao {

    @Select("select id,name,parentid from xc_category")
    List<Category> findCateZtree();
}
