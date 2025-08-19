package com.florido.dslist.controller;

import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.model.Games;
import com.florido.dslist.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GamesRecordDto>> getAllGames(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllGames());
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody @Valid Games games){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.createGame(games));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGameId(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getGameId(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Object> updateGame(@RequestBody @Valid Games games,@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.updateGame(games,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGame(@PathVariable(value = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.deleteGame(id));
    }
}
