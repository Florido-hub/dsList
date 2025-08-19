package com.florido.dslist.services;

import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.model.Games;
import com.florido.dslist.repositories.GameRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<GamesRecordDto> getAllGames(){
        var games = repository.findAll();
        List<GamesRecordDto> dto = games.stream().map(x -> new GamesRecordDto(x)).toList();
        return dto;
    }

    public GamesRecordDto createGame(@RequestBody @Valid Games games){
        return new GamesRecordDto(games);
    }

    public GamesRecordDto getGameId(UUID id){
        var game = repository.findById(id);
        if(game.isEmpty())
            throw new RuntimeException("Game not found");
        return new GamesRecordDto(game.get());
    }

    public GamesRecordDto updateGame(Games game, UUID id){
        var game0 = repository.findById(id);
        if(game0.isEmpty())
            throw new RuntimeException("Game not found");
        var game1 = game0.get();
        BeanUtils.copyProperties(game, game1, "id");
        repository.save(game1);
        return new GamesRecordDto(game1);
    }

    public GamesRecordDto deleteGame(UUID id) {
        var game0 = repository.findById(id);
        if (game0.isEmpty()) {
            throw new RuntimeException("Game not found");
        }
        repository.deleteById(id);
        return new GamesRecordDto(game0.get());
    }
}
