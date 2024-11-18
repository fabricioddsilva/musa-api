package com.kaos.musa.services;

import com.kaos.musa.entities.User;
import com.kaos.musa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public void insert(User user){
        repository.save(user);
    }
}
