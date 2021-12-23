package example.logic;

import example.entity.Team;
import example.repository.TeamRepository;
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
