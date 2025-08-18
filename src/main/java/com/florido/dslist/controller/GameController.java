package com.florido.dslist.controller;

import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.model.Games;
import com.florido.dslist.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GamesRecordDto>> getAllGames(){
        return gameService.getAllGames();
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody @Valid Games games){
        return gameService.createGame(games);
    }
}
