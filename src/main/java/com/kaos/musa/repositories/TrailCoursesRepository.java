package com.kaos.musa.repositories;

import com.kaos.musa.entities.TrailCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailCoursesRepository extends JpaRepository<TrailCourses, Integer> {

    @Query(value = "select " +
            "t.*, c.* " +
            "from trail_courses as tc " +
            "join trails as t on tc.trail_id = t.trail_id " +
            "join courses as c on tc.course_id = c.course_id " +
            "where t.trail_id = ?", nativeQuery = true)
    List<TrailCourses> findTrailCoursesByTrailId(Integer trailId);
}
