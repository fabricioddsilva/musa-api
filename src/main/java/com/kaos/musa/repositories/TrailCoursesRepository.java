package com.kaos.musa.repositories;

import com.kaos.musa.entities.TrailCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailCoursesRepository extends JpaRepository<TrailCourses, Integer> {
}
