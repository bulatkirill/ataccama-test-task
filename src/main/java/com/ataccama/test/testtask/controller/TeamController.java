package com.ataccama.test.testtask.controller;

import com.ataccama.test.testtask.model.Team;
import com.ataccama.test.testtask.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeamController {

    private TeamService teamService;

    @GetMapping("/teams")
    public String getAllTeams(Model model) {
        List<Team> teams = teamService.findAll();
        Map<String, Integer> managedConnections = new HashMap<>();
        if (teams != null) {
            for (Team team : teams) {
                managedConnections.put(team.getName(), team.getDbConnections() != null ? team.getDbConnections().size() : 0);
            }
        }
        model.addAttribute("managedConnections", managedConnections);
        model.addAttribute("teams", teams);
        return "teams";
    }

    @GetMapping("/teams/{id}")
    public String getTeamById(@PathVariable("id") Long id, Model model) {
        Team team = teamService.findById(id);
        model.addAttribute("team", team);
        return "team";
    }

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }
}
