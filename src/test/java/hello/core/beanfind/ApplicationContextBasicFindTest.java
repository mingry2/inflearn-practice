package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

//        System.out.println("memverService = " + memberService);
//        System.out.println("memverService.getClass() = " + memberService.getClass());
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        // 같은 타입이 여러개 일 경우 곤란
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        // 위 코드들은 인터페이스인 MemberService로 조회했지만,
        // 구현체인 MemberServcieImpl로도 조회가능하다.
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX() {
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
                // 해당 에러가 나와야 성공
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                // 아래의 코드가 실행됐을때,
                () -> ac.getBean("xxxx", MemberService.class));

    }

}
