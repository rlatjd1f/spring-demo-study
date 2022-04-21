package com.example.springdemostudy.discount;

import com.example.springdemostudy.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
