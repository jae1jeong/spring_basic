package hello.core.order;

import hello.core.member.Member;

public interface DiscountPolicy {
    int discount(int price, Member member);
}
