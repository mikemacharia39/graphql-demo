package com.mikehenry.graphqldemo.resolver;

import com.mikehenry.graphqldemo.model.StudentCourse;
import com.mikehenry.graphqldemo.response.StudentResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<StudentCourse> getStudentCourses(StudentResponse studentResponse) {
        List<StudentCourse> studentCourses = new ArrayList<>();
        if (!studentResponse.getStudent().getStudentCourses().isEmpty()) {
            studentCourses.addAll(studentResponse.getStudent().getStudentCourses());
        }
        return studentCourses;
    }
}
