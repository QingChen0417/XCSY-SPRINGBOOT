package com.zzxy.xc.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//菜单dao层
@Mapper
public interface MenuDao {
    /**
     * 查找所有数据
     * */
    List<Map<String, Object>> findObjects();
}
