package jpa;

import jpa.entity.Member;
import jpa.entity.MemberSort;
import jpa.logic.MemberLogic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = JpaStudyApplicationTest.class)
class MemberLogicTest {
    //
    @Autowired
    private MemberLogic memberLogic;

//    @Test
//    void contextLoads() {
//    }

    @Test
    void save() {
        //
        Member member = new Member("홍길동", 30);
        String id = memberLogic.save(member);

        Member found = memberLogic.find(id);

        assertEquals(member.getUsername(), found.getUsername());
    }

    @Test
    void findAll() {
        //
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member("홍길동", 30));
        memberList.add(new Member("이순신", 50));
        memberList.add(new Member("피터 파커", 17));
        memberList.add(new Member("김길동", 80));
        memberList.add(new Member("마동석", 40));
        memberList.add(new Member("아이언맨", 35));
        memberList.add(new Member("스칼렛요한슨", 21));
        memberList.add(new Member("캡틴아메리카", 28));

//        for (Member member : memberList) {
//            memberLogic.save(member);
//        }

        int offset = 0;
        int limit = 5;

        Page<Member> memberPage = memberLogic.findAll(offset, limit, MemberSort.AgeAsc);

        int quotient = memberList.size() / limit;

        assertEquals(memberPage.getTotalPages(), memberList.size() % limit == 0 ? quotient : quotient + 1);
        assertTrue(memberPage.getContent().size() <= limit);
        assertEquals(memberPage.getContent().get(0).getAge(), 17);

    }

}
