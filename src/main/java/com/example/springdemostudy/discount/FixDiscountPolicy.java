package com.example.springdemostudy.discount;

import com.example.springdemostudy.member.Grade;
import com.example.springdemostudy.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private final int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
