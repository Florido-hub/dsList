package com.florido.dslist.services;

import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.model.Games;
import com.florido.dslist.repositories.GameRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

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
}
