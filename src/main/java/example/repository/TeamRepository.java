package example.repository;

import example.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team, String> {
    //

}
