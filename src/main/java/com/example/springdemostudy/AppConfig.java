package com.example.springdemostudy;

import com.example.springdemostudy.discount.DiscountPolicy;
import com.example.springdemostudy.discount.RateDiscountPolicy;
import com.example.springdemostudy.member.MemberRepository;
import com.example.springdemostudy.member.MemberService;
import com.example.springdemostudy.member.MemberServiceImpl;
import com.example.springdemostudy.member.MemoryMemberRepository;
import com.example.springdemostudy.order.OrderService;
import com.example.springdemostudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
