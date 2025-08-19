package com.florido.dslist.services;

import com.florido.dslist.dtos.GameDto;
import com.florido.dslist.dtos.GamesRecordDto;
import com.florido.dslist.model.Games;
import com.florido.dslist.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameService(GameRepository repository) {
        this.gameRepository = repository;
    }

    public Games createGame(Games games){
        gameRepository.save(games);
        return games;
    }

    @Transactional(readOnly = true)
    public List<GamesRecordDto> getAllGames(){
        var games = gameRepository.findAll();
        return games.stream().map(x -> new GamesRecordDto(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDto getGameId(Long id){
        var game = gameRepository.findById(id);
        if(game.isEmpty())
            throw new RuntimeException("Game not found");
        return new GameDto(game.get());
    }

    @Transactional(readOnly = true)
    public GamesRecordDto updateGame(Games game, Long id){
        var game0 = gameRepository.findById(id);
        if(game0.isEmpty())
            throw new RuntimeException("Game not found");
        var game1 = game0.get();
        BeanUtils.copyProperties(game, game1, "id");
        gameRepository.save(game1);
        return new GamesRecordDto(game1);
    }

    @Transactional(readOnly = true)
    public GamesRecordDto deleteGame(Long id) {
        var game0 = gameRepository.findById(id);
        if (game0.isEmpty()) {
            throw new RuntimeException("Game not found");
        }
        gameRepository.deleteById(id);
        return new GamesRecordDto(game0.get());
    }
}
