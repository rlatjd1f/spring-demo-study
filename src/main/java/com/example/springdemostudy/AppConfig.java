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
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }
}
