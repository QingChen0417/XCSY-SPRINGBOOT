package com.zzxy.xc.dao;

import com.zzxy.xc.vo.UsermemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//用户数据层接口
@Mapper
public interface UserDao {


    /**
     * 通过用户id修改用户状态
     * @param id
     * @param valid
     * @return
     */
    @Update("update xc_users set valid = #{valid} where id = #{id}")
    Integer updateValid(@Param("id") Integer id, @Param("valid") Integer valid);
}
