package com.ataccama.test.testtask.service;

import com.ataccama.test.testtask.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> findAll();

    Team findById(Long id);

    Team add(Team team);

    List<Team> addALL(List<Team> teams);
}
