package example;

import book.chapter5.Member;
import book.chapter5.Team;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@SpringBootTest(classes = JpaStudyApplicationTest.class)
public class BookMainTest {
    //
    protected static EntityManagerFactory emf;
    protected EntityManager em;


    @BeforeAll
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("jpabook");
    }

    @AfterAll
    public static void closeEntityManagerFactory() {
        emf.close();
    }

    @BeforeEach
    public void beginTransaction() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @AfterEach
    public void rollbackTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }

        if (em.isOpen()) {
            em.close();
        }
    }

    @Test
    void test() {
        //
        //TODO 비즈니스 로직
        Team team = new Team("team1", "팀1");
        em.persist(team);

        Member member = new Member("member1", "회원1");
        em.persist(member);
    }
}
