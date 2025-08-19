package com.florido.dslist.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BelonginPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Games games;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;


    public BelonginPK() {
    }

    public BelonginPK(Games games, GameList gameList) {
        this.games = games;
        this.gameList = gameList;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelonginPK that)) return false;
        return Objects.equals(games, that.games) && Objects.equals(gameList, that.gameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(games, gameList);
    }
}
