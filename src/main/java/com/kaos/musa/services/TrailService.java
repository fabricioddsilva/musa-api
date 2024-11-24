package com.kaos.musa.services;

import com.kaos.musa.entities.*;
import com.kaos.musa.entities.dto.CourseSubscribeDTO;
import com.kaos.musa.entities.dto.TrailSubscribeDTO;
import com.kaos.musa.entities.enums.CourseStatus;
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

    @Autowired
    private CourseProgressRepository courseProgressRepository;

    public List<Trail> findAll(){
        return trailRepository.findAll();
    }

    public void insert(Trail trail){
        trailRepository.save(trail);
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

    public void subscribeUserToTrail(TrailSubscribeDTO data){
        if(userRepository.existsById(data.userId())){
                trailProgressRepository.save(new TrailProgress(
                        trailRepository.findById(data.trailId()).get(),
                        userRepository.findById(data.userId()).get(),
                        LocalDateTime.now(),
                        0.0
                ));
            } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void subscribeUserToCourse(CourseSubscribeDTO data){
        courseProgressRepository.save(new CourseProgress(
                userRepository.findById(data.userId()).get(),
                courseRepository.findById(data.courseId()).get(),
                trailRepository.findById(data.trailId()).get(),
                LocalDateTime.now(),
                CourseStatus.ANDAMENTO
        ));
    }
}

