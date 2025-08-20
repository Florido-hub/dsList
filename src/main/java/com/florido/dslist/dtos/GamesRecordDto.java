package com.florido.dslist.dtos;

import com.florido.dslist.model.Games;
import com.florido.dslist.projections.GameMinProjection;
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

    public GamesRecordDto(GameMinProjection entity) {
        BeanUtils.copyProperties(entity, this);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
