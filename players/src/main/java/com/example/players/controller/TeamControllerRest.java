package com.example.players.controller;

import com.example.players.model.Team;
import com.example.players.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teams")
public class TeamControllerRest {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Team> getTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams;
    }
}
