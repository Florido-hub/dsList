package com.florido.dslist.dtos;

import com.florido.dslist.model.Games;

import java.util.Optional;
import java.util.UUID;

public class GamesRecordDto{
    private UUID id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GamesRecordDto() {
    }

    public GamesRecordDto(Games games) {
        this.id = games.getId();
        this.title = games.getTitle();
        this.year = games.getYear();
        this.imgUrl = games.getImgUrl();
        this.shortDescription = games.getShortDescription();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
