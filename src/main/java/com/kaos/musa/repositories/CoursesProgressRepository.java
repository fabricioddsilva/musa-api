package com.kaos.musa.repositories;

import com.kaos.musa.entities.CoursesProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesProgressRepository extends JpaRepository<CoursesProgress, Integer> {
}
