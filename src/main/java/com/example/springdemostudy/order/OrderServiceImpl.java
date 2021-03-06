package com.example.springdemostudy.order;

import com.example.springdemostudy.annotation.MainDiscountPolicy;
import com.example.springdemostudy.discount.DiscountPolicy;
import com.example.springdemostudy.member.Member;
import com.example.springdemostudy.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //Singleton 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
