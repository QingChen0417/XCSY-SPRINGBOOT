package com.zzxy.xc.service.impl;

import com.zzxy.xc.dao.MemberDao;
import com.zzxy.xc.entity.Member;
import com.zzxy.xc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao dao;

    public List<Member> findMemberZtree() {
        List<Member> list = dao.findMemberZtree();
        return list;
    }
}
