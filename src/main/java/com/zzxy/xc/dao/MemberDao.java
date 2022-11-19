package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDao {

    /**
     * 通过会员id查找会员信息
     * @param memberId
     * @return
     */
    @Select("select * from xc_members where id = #{memberId}")
    Member findMemberById(Integer memberId);
}
