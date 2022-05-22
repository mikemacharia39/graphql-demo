package com.mikehenry.graphqldemo.repositiory;

import com.mikehenry.graphqldemo.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
}
