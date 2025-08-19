package com.florido.dslist.services;

import com.florido.dslist.dtos.ListsDto;
import com.florido.dslist.model.GameList;
import com.florido.dslist.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    @Transactional(readOnly = true)
    public List<ListsDto> getAllList(){
        var gamesList = listRepository.findAll();
        List<ListsDto> listDto = gamesList.stream().map(y -> new ListsDto(y)).toList();
        return listDto;
    }

    @Transactional(readOnly = true)
    public GameList createList(GameList list){
        listRepository.save(list);
        return list;
    }
}
