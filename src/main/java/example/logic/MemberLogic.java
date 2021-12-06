package example.logic;

import example.entity.Member;
import example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberLogic {
    //
    private final MemberRepository memberRepository;

    public String save(Member member) {
        //
        return memberRepository.save(member).getId();
    }

    public Member find(String id) {
        //
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElse(null);
    }

}
