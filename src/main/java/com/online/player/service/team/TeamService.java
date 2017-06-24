package com.online.player.service.team;

import com.online.player.dto.team.CreateTeamRequest;
import com.online.player.dto.team.TeamResponse;
import com.online.player.dto.team.UpdateTeamRequest;
import org.springframework.data.domain.Page;

/**
 * Created by ikota on 11.6.17.
 */
public interface TeamService {
    
    Page<TeamResponse> getAll(int page, int size);

    TeamResponse getById(Long id);

    TeamResponse create(CreateTeamRequest request);

    TeamResponse update(Long id, UpdateTeamRequest request);

    void delete(Long id);

}
