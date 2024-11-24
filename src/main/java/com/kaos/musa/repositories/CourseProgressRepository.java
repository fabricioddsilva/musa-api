package com.kaos.musa.repositories;

import com.kaos.musa.entities.CourseProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseProgressRepository extends JpaRepository<CourseProgress, Integer> {

    @Query(value = "select * from course_progress where user_id = ?", nativeQuery = true)
    List<CourseProgress> findCoursesByUserId(int userId);
}
