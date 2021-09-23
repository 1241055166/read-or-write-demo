package com.henry.mapper;


import com.henry.entity.Member;
import com.henry.entity.MemberExample;

import java.util.List;

public interface MemberMapper {

    int insert(Member member);

    int save(Member member);

    List<Member> selectByExample(MemberExample memberExample);
}
