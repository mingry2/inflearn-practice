package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 정보, 구성 정보
public class AppConfig {

    // 생성자 주입

    // MemberService 역할이 드러나게 해줌
    @Bean // 빈 등록 -> 어노테이션이 붙은 메소드들은 스프링 컨테이너에 등록됨
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());

    }


    // MemberRepository 역할이 드러나게 해줌
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();

    }

    // OrderService 역할이 드러나게 해줌
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }

    // DiscountPolicy 역할이 드러나게 해줌
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();

    }
}
