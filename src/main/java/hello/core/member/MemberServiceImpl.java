package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 빈이 자동으로 등록되지만 의존관계를 지정할 수 없다 이 때, @Autowired 사용
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // 자동 의존관계 주입 == ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return  memberRepository;

    }

}
