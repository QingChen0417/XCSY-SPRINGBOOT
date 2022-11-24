package com.zzxy.xc.dao;

import com.zzxy.xc.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberDao {

    /**
     * 通过会员id查找会员信息
     *
     */
    @Select("select * from xc_members where id = #{memberId}")
    Member findMemberById(Integer memberId);

    /**
     * 查找所有会员信息
     * @return 会员集合
     */
    @Select("select * from xc_members")
    List<Member> findMemberZtree();
}
