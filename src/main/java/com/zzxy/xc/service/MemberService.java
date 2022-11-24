package com.zzxy.xc.service;

import com.zzxy.xc.entity.Member;

import java.util.List;

public interface MemberService {

    /**
     * 查找所有会员等级
     * @return 会员集合
     */
    List<Member> findMemberZtree();
}
