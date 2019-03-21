package com.example.players;

import com.example.players.model.Player;
import com.example.players.model.Team;
import com.example.players.repository.PlayerRepository;
import com.example.players.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Override
    public void run(String... args) throws Exception {

        Stream.of(
                new Team("Zaksa" , "Polska"),
                new Team("Trefl Gdańsk", "Polska"),
                new Team("ONICO Warszawa", "Polska")
        ).forEach(teamRepository::save);


        Stream.of(
                new Player("Bartosz", "Kurek",  "Atakujący", 205, 100, 370, teamRepository.findById(3L).get()),
                new Player("Maciej", "Muzaj", "Atakujący", 205, 100, 370 , teamRepository.findById(2L).get()),
                new Player("Łukasz", "Kaczmarek", "Atakujący", 205, 100, 370, teamRepository.findById(1L).get()),
                new Player("Łukasz", "Kaczmarek", "Atakujący", 205, 100, 370)
        ).forEach(playerRepository::save);

    }
}
