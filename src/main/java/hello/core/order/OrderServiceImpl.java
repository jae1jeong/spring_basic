package hello.core.order;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private MemberRepository memberRepository;

    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 위반 추상클래스에 의존해야하는데 구체적인 클래스에 함꼐 의존하고 있다  DIP 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // Fix -> Rate 변경하는 순간 OrderServiceImpl의 소스코드도 함께 변경해야 한다 OCP 위반

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member targetMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(itemPrice, targetMember);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
