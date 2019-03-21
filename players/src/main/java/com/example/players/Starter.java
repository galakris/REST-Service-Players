package com.example.players;

import com.example.players.model.Player;
import com.example.players.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of(
                new Player("Bartosz", "Kurek", "ONICO", "Atakujący", 205, 100, 370),
                new Player("Maciej", "Muzaj", "JSW", "Atakujący", 205, 100, 370),
                new Player("Łukasz", "Kaczmarek", "Zaksa", "Atakujący", 205, 100, 370)
        ).forEach(playerRepository::save);

    }
}
