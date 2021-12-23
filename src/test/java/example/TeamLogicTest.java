package example;

import example.entity.Team;
import example.logic.TeamLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = JpaStudyApplicationTest.class)
public class TeamLogicTest {
    //
    @Autowired
    private TeamLogic teamLogic;

    @DisplayName("Transient어노테이션 확인")
    @Test
    void find() {
        //
        Team team = Team.sample();
        String id = teamLogic.register(team);

        Team found = teamLogic.findById(id);

        assertTrue(!CollectionUtils.isEmpty(team.getMembers()));
        assertNull(found.getMembers());

    }
}
