package com.online.player.service.team.impl;

import com.online.player.dto.team.CreateTeamRequest;
import com.online.player.dto.team.TeamResponse;
import com.online.player.dto.team.UpdateTeamRequest;
import com.online.player.exception.EntityNotFoundException;
import com.online.player.model.team.Team;
import com.online.player.repository.team.TeamRepository;
import com.online.player.service.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by ikota on 11.6.17.
 */
@Service
public class TeamServiceImpl implements TeamService {


    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Page<TeamResponse> getAll(int page, int size) {
        Page<Team> TeamPage = teamRepository.findAll(new PageRequest(page, size));
        return new PageImpl<>(TeamPage.getContent().stream().map(TeamResponse::new).collect(Collectors.toList()),
                new PageRequest(page, size), TeamPage.getTotalElements());
    }

    @Override
    public TeamResponse getById(Long id) {
        if (!teamRepository.exists(id)) {
            throw new EntityNotFoundException("Team is not found.");
        }
        return new TeamResponse(teamRepository.findOne(id));
    }

    @Override
    public TeamResponse create(CreateTeamRequest request) {
        return new TeamResponse(teamRepository.save(new Team()
                .setName(request.getName())));

    }

    @Override
    public TeamResponse update(Long id, UpdateTeamRequest request) {
        if (!teamRepository.exists(id)) {
            throw new EntityNotFoundException("Team is not found.");
        }

        return new TeamResponse(teamRepository.save(teamRepository.findOne(id)
                .setName(request.getName())));
    }

    @Override
    public void delete(Long id) {
        if (!teamRepository.exists(id)) {
            throw new EntityNotFoundException("Team is not found.");
        }

        teamRepository.delete(id);
    }

}
