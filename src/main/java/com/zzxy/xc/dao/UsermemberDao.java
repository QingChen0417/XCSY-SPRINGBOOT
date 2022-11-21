package com.zzxy.xc.dao;

import com.zzxy.xc.vo.UsermemberVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsermemberDao {
    /**
     * 通过用户名查找用户和会员信息
     * @param username
     * @return
     */
    public List<UsermemberVo> findUsermemberVo(String username);
}
