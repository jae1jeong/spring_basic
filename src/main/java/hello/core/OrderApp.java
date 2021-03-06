package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = AppConfig.getInstance().memberService();
        OrderService orderService = AppConfig.getInstance().orderService();


        Long memberId = 1L;
        Member member = new Member(memberId,"james",Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, member.getName(), 20000);
        System.out.println("order: "+ order);

    }
}
