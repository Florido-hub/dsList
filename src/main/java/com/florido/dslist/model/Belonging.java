package com.florido.dslist.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelonginPK id = new BelonginPK();

    private Integer Position;

    public Belonging() {
    }

    public Belonging(Games games, GameList gameList, Integer position) {
        this.id.setGames(games);
        this.id.setGameList(gameList);
        Position = position;
    }

    public BelonginPK getId() {
        return id;
    }

    public void setId(BelonginPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Belonging belonging)) return false;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
