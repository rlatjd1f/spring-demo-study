package com.example.springdemostudy.autowired;

import com.example.springdemostudy.AutoAppConfig;
import com.example.springdemostudy.member.Grade;
import com.example.springdemostudy.member.Member;
import com.example.springdemostudy.member.MemberService;
import com.example.springdemostudy.order.Order;
import com.example.springdemostudy.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierTest {

    @Test
    void discountTest(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "A", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order.getDiscountPrice() = " + order.getDiscountPrice());
    }
}
