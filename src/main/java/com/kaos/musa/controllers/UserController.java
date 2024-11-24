package com.kaos.musa.controllers;

import com.kaos.musa.entities.CourseProgress;
import com.kaos.musa.entities.TrailProgress;
import com.kaos.musa.entities.User;
import com.kaos.musa.entities.dto.CourseSubscribeDTO;
import com.kaos.musa.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /* Trail Relations */

    @GetMapping("/{id}/trails")
    public ResponseEntity<List<TrailProgress>> findAllTrailProgressById(@PathVariable(name = "id") Integer userId){
        return ResponseEntity.ok().body(userService.findAllTrailProgressById(userId));
    }

    /* Course Relations */

    @GetMapping("{id}/trails/courses")
    public ResponseEntity<List<CourseProgress>> findAllCourseProgressById(@PathVariable(name = "id") int userId){
        return ResponseEntity.ok().body(userService.findAllCourseProgressById(userId));
    }


}
