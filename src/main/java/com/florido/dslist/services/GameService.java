package com.florido.dslist.services;

import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
