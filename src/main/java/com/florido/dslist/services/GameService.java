package com.florido.dslist.services;

import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.model.Games;
import com.florido.dslist.repositories.GameRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<GamesRecordDto>> getAllGames(){
        var games = repository.findAll();
        List<GamesRecordDto> dto = games.stream().map(x -> new GamesRecordDto(x)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    public ResponseEntity<Object> createGame(@RequestBody @Valid Games games){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(games));
    }

    public ResponseEntity<Object> getGameId(UUID id){
        var game = repository.findById(id);
        if(game.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        return ResponseEntity.status(HttpStatus.OK).body(game.get());
    }

    public ResponseEntity<Object> updateGame(Games game, UUID id){
        var game0 = repository.findById(id);
        if(game0.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        var game1 = game0.get();
        BeanUtils.copyProperties(game, game1);
        return ResponseEntity.status(HttpStatus.OK).body(game1);
    }

    public ResponseEntity<Object> deleteGame(UUID id){
        var game0 = repository.findById(id);
        if(game0.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("game deleted");
    }
}
