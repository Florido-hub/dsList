package com.florido.dslist.controller;

import com.florido.dslist.dtos.ListsDto;
import com.florido.dslist.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping
    public ResponseEntity<List<ListsDto>> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(listService.getAllList());
    }
}
