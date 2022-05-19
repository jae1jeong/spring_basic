package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = AppConfig.getInstance().memberService();
    OrderService orderService = AppConfig.getInstance().orderService();

    @Test
    void createOrderVIP(){
        Long memberId = 1L;
        Member member = new Member(memberId,"james", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, member.getName(), 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void createOrderBasic(){
        Long memberId = 1L;
        Member member = new Member(memberId,"james", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, member.getName(), 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);

    }

}