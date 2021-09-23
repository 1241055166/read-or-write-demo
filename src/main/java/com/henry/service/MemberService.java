package com.henry.service;

import com.henry.entity.Member;

import java.util.List;


public interface MemberService {

    public int insert(Member member);

    public int save(Member member);

    public List<Member> selectAll();

    public String getToken(String appId);
}
