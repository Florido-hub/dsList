package com.florido.dslist.controller;

import com.florido.dslist.dtos.ListsDto;
import com.florido.dslist.model.GameList;
import com.florido.dslist.services.ListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {

    @Autowired
    private ListService listService;

    @PostMapping
    public ResponseEntity<Object> createList(@RequestBody @Valid GameList list){
        return ResponseEntity.status(HttpStatus.OK).body(listService.createList(list));
    }

    @GetMapping
    public ResponseEntity<List<ListsDto>> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(listService.getAllList());
    }
}
