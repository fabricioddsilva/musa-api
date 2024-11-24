package com.kaos.musa.controllers;

import com.kaos.musa.entities.Course;
import com.kaos.musa.entities.Lesson;
import com.kaos.musa.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Course course){
        courseService.insert(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/lesson")
    public ResponseEntity<Void> insertLesson(@RequestBody Lesson lesson, @PathVariable Integer id){
        courseService.insertLesson(lesson, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.ok().body(courseService.findAll());
    }

    @GetMapping("/{id}/lesson")
    public ResponseEntity<List<Lesson>> findAllByCourse(@PathVariable Integer id){
        return ResponseEntity.ok().body(courseService.findAllLessonsByCourse(id));
    }




}
