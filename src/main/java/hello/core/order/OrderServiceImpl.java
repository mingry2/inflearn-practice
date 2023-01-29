package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    /*
    역할과 구현을 충분하게 분리? OK
    다형성도 활용하고, 인터페이스와 구현 객체를 분리? OK
    OCP, DIP 같은 객체지향 설계 원칙을 충실히 준수? NO
    -> DIP 위반 : DiscountPolicy(추상)를 의존하는 것 뿐만 아니라 FixDiscountPolicy(구체)도 의존하고 있다.
    -> OCP 위반 : FixDiscountPolicy를 RateDiscountPolicy로 변경하기 위해선 DiscountPolicy의 코드를 변경해야한다.
    */
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
