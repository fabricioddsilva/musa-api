package com.kaos.musa.controllers;

import com.kaos.musa.entities.User;
import com.kaos.musa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        service.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
