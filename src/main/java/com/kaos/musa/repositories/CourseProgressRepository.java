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

    @Query(value = "select * from course_progress where user_id = ? and course_id = ?",nativeQuery = true)
    CourseProgress findCourseByUserAndCourse(int userId, int courseId);

    @Query(value = "select count(course_status) from course_progress where course_status = 'COMPLETO' and user_id = ? and trail_id = ? ", nativeQuery = true)
    int countCoursesCompleted(int userId, int trailId);

    @Query(value = "update from trail_progress set trail_completion = ? where trail_id = ? and user_id = ?",nativeQuery = true)
    void updateCompletion(double completion, int trailId, int userId);
}
