package com.example.springdemostudy;

import com.example.springdemostudy.member.Grade;
import com.example.springdemostudy.member.Member;
import com.example.springdemostudy.member.MemberService;
import com.example.springdemostudy.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.*;

class MemberAppTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){

        //given
        Member member = new Member(1L,"memA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then`
        assertThat(member).isEqualTo(findMember);
    }
}