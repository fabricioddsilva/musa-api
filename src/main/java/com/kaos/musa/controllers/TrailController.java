package com.kaos.musa.controllers;

import com.kaos.musa.entities.Trail;
import com.kaos.musa.entities.TrailCourses;
import com.kaos.musa.entities.dto.CourseSubscribeDTO;
import com.kaos.musa.entities.dto.TrailSubscribeDTO;
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

    @PostMapping("/user/subscribe")
    public ResponseEntity<Void> subscribeUserToTrail(@RequestBody TrailSubscribeDTO data){
        trailService.subscribeUserToTrail(data);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/course/user/subscribe")
    public ResponseEntity<Void> subscribeUserToCourse(@RequestBody CourseSubscribeDTO data){
        trailService.subscribeUserToCourse(data);
        return ResponseEntity.accepted().build();
    }




}
