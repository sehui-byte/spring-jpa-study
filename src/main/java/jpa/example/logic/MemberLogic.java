package jpa.example.logic;

import jpa.example.entity.Member;
import jpa.example.entity.MemberSort;
import jpa.example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Member> findAll(int offset, int limit, MemberSort memberSort) {
        //
        Pageable pageable = PageRequest.of(offset, limit, getMemberSort(memberSort));

        return memberRepository.findAll(pageable);

    }

    private Sort getMemberSort(MemberSort memberSort) {
        //
        switch (memberSort) {
            case UsernameAsc:
                return Sort.by(new Sort.Order(Sort.Direction.ASC, "username"));
            case UsernameDesc:
                return Sort.by(new Sort.Order(Sort.Direction.DESC, "username"));
            case AgeDesc:
                return Sort.by(new Sort.Order(Sort.Direction.DESC, "age"));
            case AgeAsc:
                return Sort.by(new Sort.Order(Sort.Direction.ASC, "age"));
            default:
                return Sort.by(new Sort.Order(Sort.Direction.ASC, "username"));
        }
    }

}
