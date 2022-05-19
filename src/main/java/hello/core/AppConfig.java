package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.*;


// 실제 동작에 필요한 구현 객체를 생성한다.
// 사용 영역 코드는 변경할 필요가 없어짐
public class AppConfig {
    public static AppConfig appConfig;

    public static AppConfig getInstance(){
        if(appConfig == null){
            appConfig = new AppConfig();
        }
        return appConfig;
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
