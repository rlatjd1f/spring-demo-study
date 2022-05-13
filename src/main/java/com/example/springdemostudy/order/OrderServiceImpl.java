package com.example.springdemostudy.order;

import com.example.springdemostudy.discount.DiscountPolicy;
import com.example.springdemostudy.member.Member;
import com.example.springdemostudy.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy rateDiscountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = rateDiscountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //Singleton 테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
