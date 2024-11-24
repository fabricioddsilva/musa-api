package com.kaos.musa.repositories;

import com.kaos.musa.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    @Query(value = "select * from lessons where course_id = ?", nativeQuery = true)
    List<Lesson> findAllByCourse(Integer id);
}
