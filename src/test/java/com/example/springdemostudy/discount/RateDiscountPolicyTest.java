package com.example.springdemostudy.discount;

import com.example.springdemostudy.member.Grade;
import com.example.springdemostudy.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP = 10% discount")
    void vip_o() {
        Member member = new Member(1L, "A", Grade.VIP);

        int discountPrice = discountPolicy.discount(member, 10000);

        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    void vip_x() {
        Member member = new Member(1L, "A", Grade.BASIC);

        int discountPrice = discountPolicy.discount(member, 10000);

        assertThat(discountPrice).isEqualTo(0);

    }
}