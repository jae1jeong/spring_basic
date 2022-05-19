package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP회원이 정율로 할인 받아야 한다.")
    void vip_o(){
        // given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discountPrice = discountPolicy.discount(10_000, memberVIP);
        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반회원이 정율로 할인 받으면 안 된다.")
    void vip_x(){
        // given
        Member memberBasic = new Member(1L, "memberBasic", Grade.BASIC);
        // when
        int discountPrice = discountPolicy.discount(10_000, memberBasic);
        // then
        assertThat(discountPrice).isEqualTo(0);

    }

}