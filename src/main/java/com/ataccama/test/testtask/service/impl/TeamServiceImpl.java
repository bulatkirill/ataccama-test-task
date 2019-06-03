package com.ataccama.test.testtask.service.impl;

import com.ataccama.test.testtask.model.Team;
import com.ataccama.test.testtask.repository.TeamRepository;
import com.ataccama.test.testtask.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public Team add(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> addALL(List<Team> teams) {
        return teamRepository.saveAll(teams);
    }

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
}
