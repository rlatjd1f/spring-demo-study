package com.example.springdemostudy.discount;

import com.example.springdemostudy.member.Grade;
import com.example.springdemostudy.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            int discountPercent = 10;
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
