package com.kaos.musa.repositories;

import com.kaos.musa.entities.TrailProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailProgressRepository extends JpaRepository<TrailProgress, Integer> {

    @Query(value = "select * from trail_progress where user_id = ?" ,nativeQuery = true)
    List<TrailProgress> findAllByUserId(int userId);
}
