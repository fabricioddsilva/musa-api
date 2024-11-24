package com.kaos.musa.services;

import com.kaos.musa.entities.CourseProgress;
import com.kaos.musa.entities.TrailProgress;
import com.kaos.musa.entities.User;
import com.kaos.musa.repositories.CourseProgressRepository;
import com.kaos.musa.repositories.TrailProgressRepository;
import com.kaos.musa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrailProgressRepository trailProgressRepository;

    @Autowired
    private CourseProgressRepository courseProgressRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void insert(User user){
        userRepository.save(user);
    }

    public List<TrailProgress> findAllTrailProgressById(int userId){
        return trailProgressRepository.findAllByUserId(userId);
    }

    public List<CourseProgress> findAllCourseProgressById(int userId){
        return courseProgressRepository.findCoursesByUserId(userId);
    }


}
