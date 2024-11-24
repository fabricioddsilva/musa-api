package com.kaos.musa.services;

import com.kaos.musa.entities.Trail;
import com.kaos.musa.repositories.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailService {

    @Autowired
    private TrailRepository repository;

    public List<Trail> findAll(){
        return repository.findAll();
    }

    public void insert(Trail trail){
        repository.save(trail);
    }

    public Trail findById(Integer id){
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("Não encontrado");
        }
        return repository.findById(id).get();
    }

    public void insertLessons(){

    }
}

