package jpa.example;

import jpa.JpaStudyApplicationTest;
import jpa.example.entity.Member;
import jpa.example.entity.MemberSort;
import jpa.example.entity.Team;
import jpa.example.logic.MemberLogic;
import jpa.example.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = JpaStudyApplicationTest.class)
class MemberLogicTest {
    //
    @Autowired
    private MemberLogic memberLogic;
    @Autowired
    private TeamRepository teamRepository;

//    @Test
//    void contextLoads() {
//    }

    @Test
    void saveMember() {
        //
        Member member = new Member("홍길동", 30);
        Team team = new Team(UUID.randomUUID().toString(), "홍길동팀",
                "안녕하세요. 홍길동팀입니다.",
                Date.valueOf("2021-01-09"));
        String teamId = teamRepository.save(team).getId();
        member.setTeam(team);

        String id = memberLogic.save(member);
        Member found = memberLogic.find(id);
        Team foundTeam = found.getTeam();

        assertNotNull(foundTeam.getName());
        assertEquals(member.getTeam().getId(), teamId);

//        assertEquals(member.getUsername(), found.getUsername());
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
