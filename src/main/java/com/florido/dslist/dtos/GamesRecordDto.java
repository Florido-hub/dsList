package com.florido.dslist.dtos;

import com.florido.dslist.model.Games;
import org.springframework.beans.BeanUtils;

public class GamesRecordDto{
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GamesRecordDto() {
    }

    public GamesRecordDto(Games games) {
        BeanUtils.copyProperties(games, this);
    }

    public Long getId() {
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
