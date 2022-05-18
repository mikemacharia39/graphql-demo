package com.mikehenry.graphqldemo.service;

import com.mikehenry.graphqldemo.response.StudentResponse;

import java.util.List;

public interface Student {

    StudentResponse getStudent(Long id);

    List<StudentResponse> getAllStudents();
}
