package example;

import example.entity.Member;
import example.logic.MemberLogic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

}
