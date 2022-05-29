package com.mikehenry.graphqldemo.repositiory;

import com.mikehenry.graphqldemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
