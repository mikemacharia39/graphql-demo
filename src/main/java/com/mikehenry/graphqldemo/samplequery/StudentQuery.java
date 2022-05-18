package com.mikehenry.graphqldemo.samplequery;

import com.mikehenry.graphqldemo.response.StudentResponse;
import com.mikehenry.graphqldemo.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentQuery implements GraphQLQueryResolver {

    private StudentService studentService;
    public StudentResponse getStudent(Long studentId) {
        return studentService.getStudent(studentId);
    }
}
