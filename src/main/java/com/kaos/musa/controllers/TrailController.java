package com.kaos.musa.controllers;

import com.kaos.musa.entities.Trail;
import com.kaos.musa.services.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trails")
public class TrailController {

    @Autowired
    private TrailService service;

    @GetMapping
    public ResponseEntity<List<Trail>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> insertTrail(@RequestBody Trail trail){
        service.insert(trail);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trail> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
