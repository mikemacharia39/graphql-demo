package com.mikehenry.graphqldemo.request;

import com.mikehenry.graphqldemo.model.StudentCourse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private List<EnrolCourseRequest> studentCourses;
}
