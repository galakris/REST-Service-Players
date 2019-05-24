package com.example.players.controller;

import com.example.players.model.Player;
import com.example.players.model.Team;
import com.example.players.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveTeam(@RequestBody Team team){
        Team save = teamRepository.save(team);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId())
                .toUri();
        return ResponseEntity.created(location).body(save);
    }
}
