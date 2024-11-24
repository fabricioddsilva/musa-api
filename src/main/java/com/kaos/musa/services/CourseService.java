package com.kaos.musa.services;

import com.kaos.musa.entities.Course;
import com.kaos.musa.entities.Lesson;
import com.kaos.musa.repositories.CourseRepository;
import com.kaos.musa.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public void insert(Course course){
        courseRepository.save(course);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public void insertLesson(Lesson lesson, Integer id){
        if(courseRepository.existsById(id)){
            lesson.setCourse(courseRepository.findById(id).get());
            lessonRepository.save(lesson);
        } else {
            throw new RuntimeException("Não foi possível inserir a aula");
        }
    }

    public List<Lesson> findAllLessonsByCourse(Integer id){
        if(courseRepository.existsById(id)){
            return lessonRepository.findAllByCourse(id);
        } else {
            throw new RuntimeException("Não foi possível achar o curso");
        }
    }
}
