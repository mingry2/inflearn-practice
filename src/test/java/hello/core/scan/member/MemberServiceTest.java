package hello.core.scan.member;


import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join() {
        // given ~게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when ~게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then ~게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
