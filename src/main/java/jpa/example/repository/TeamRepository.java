package jpa.example.repository;

import jpa.example.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team, String> {
    //

}
