package com.mikehenry.graphqldemo.mutation;

import com.mikehenry.graphqldemo.request.CreateStudentRequest;
import com.mikehenry.graphqldemo.response.StudentResponse;
import com.mikehenry.graphqldemo.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentMutation implements GraphQLMutationResolver {

    private final StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }
}
