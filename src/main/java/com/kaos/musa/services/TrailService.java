package com.kaos.musa.services;

import com.kaos.musa.entities.Course;
import com.kaos.musa.entities.Trail;
import com.kaos.musa.entities.TrailCourses;
import com.kaos.musa.entities.TrailProgress;
import com.kaos.musa.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrailService {

    @Autowired
    private TrailRepository trailRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TrailCoursesRepository trailCoursesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrailProgressRepository trailProgressRepository;

    public List<Trail> findAll(){
        return trailRepository.findAll();
    }

    public void insert(Trail trail){
        trailRepository.save(trail);
    }

    public Trail findById(Integer id){
        if(trailRepository.findById(id).isEmpty()){
            throw new RuntimeException("Não encontrado");
        }
        return trailRepository.findById(id).get();
    }

    public List<TrailCourses> findAllTrailCourses(Integer id){
        if (trailRepository.existsById(id)){
            return trailCoursesRepository.findTrailCoursesByTrailId(id);
        } else {
            throw new RuntimeException("Trilha não encontrada");
        }
    }

    public void insertCourse(int trailId, int courseId){
        if (trailRepository.existsById(trailId)){
            if(courseRepository.existsById(courseId)){
                Trail trail = trailRepository.findById(trailId).get();
                Course course = courseRepository.findById(courseId).get();
                TrailCourses trailCourses = new TrailCourses(trail, course);
                trailCoursesRepository.save(trailCourses);
            } else {
                throw new RuntimeException("Curso Não Encontrado");
            }
        } else {
            throw new RuntimeException("Trilha Não Encontrada");
        }
    }

    public void subscribeUser(int trailId, int userId){
        if(userRepository.existsById(userId)){
                trailProgressRepository.save(new TrailProgress(
                        trailRepository.findById(trailId).get(),
                        userRepository.findById(userId).get(),
                        LocalDateTime.now(),
                        0.0
                ));
            } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}

