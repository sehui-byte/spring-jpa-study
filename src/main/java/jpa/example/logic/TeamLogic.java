package jpa.example.logic;

import jpa.example.entity.Team;
import jpa.example.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamLogic {
    //
    private final TeamRepository teamRepository;

    public String register(Team team) {
        //
        return teamRepository.save(team).getId();
    }

    public Team findById(String id) {
        //
        return teamRepository.findById(id).orElse(null);
    }


}
