package com.example.springdemostudy.member;

import com.example.springdemostudy.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
