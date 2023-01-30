package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 메모리에 임시로 데이터를 저장해서 DB의 역할을 하게 만듦
// 메모리이기 때문에 컴퓨터를 끄면 데이터 없어짐 -> 임시로 사용
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
