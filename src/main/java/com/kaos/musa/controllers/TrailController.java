package com.kaos.musa.controllers;

import com.kaos.musa.entities.Trail;
import com.kaos.musa.entities.TrailCourses;
import com.kaos.musa.entities.TrailProgress;
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
    private TrailService trailService;

    @GetMapping
    public ResponseEntity<List<Trail>> findAll(){
        return ResponseEntity.ok().body(trailService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> insertTrail(@RequestBody Trail trail){
        trailService.insert(trail);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /* Course Relations */
    @GetMapping("/{id}")
    public ResponseEntity<List<TrailCourses>> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(trailService.findAllTrailCourses(id));
    }

    @PostMapping("/{trail_id}/course/{course_id}")
    public ResponseEntity<Void> insertCourse (
            @PathVariable(name = "trail_id") Integer trailId, @PathVariable(name = "course_id") Integer courseId){
        trailService.insertCourse(trailId, courseId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /* User Relations */

    @PostMapping("/{trail_id}/user/{user_id}")
    public ResponseEntity<Void> subscribeUserToTrail(
            @PathVariable(name = "trail_id") Integer trailId, @PathVariable(name = "user_id") Integer userId){
        trailService.subscribeUser(trailId, userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }




}
