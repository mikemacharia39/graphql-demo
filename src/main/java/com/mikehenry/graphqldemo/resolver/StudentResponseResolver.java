package com.mikehenry.graphqldemo.resolver;

import com.mikehenry.graphqldemo.filter.CourseNameFilter;
import com.mikehenry.graphqldemo.model.StudentCourse;
import com.mikehenry.graphqldemo.response.StudentResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<StudentCourse> getStudentCourses(StudentResponse studentResponse, List<CourseNameFilter> courseNameFilter) {
        List<StudentCourse> studentCourses = new ArrayList<>();
        if (!studentResponse.getStudent().getStudentCourses().isEmpty()) {
            if (courseNameFilter.contains(CourseNameFilter.ALL)) {
                studentCourses.addAll(studentResponse.getStudent().getStudentCourses());
            } else {
                studentResponse.getStudent().getStudentCourses().forEach(studentCourse -> courseNameFilter.forEach(courseNameFilter1 -> {
                    if (courseNameFilter1.name().equalsIgnoreCase(studentCourse.getCourse().getCode())) {
                        studentCourses.add(studentCourse);
                    }
                }));
            }
        }
        return studentCourses;
    }

    public String getFullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}
