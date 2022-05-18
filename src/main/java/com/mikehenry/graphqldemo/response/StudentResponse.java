package com.mikehenry.graphqldemo.response;

import com.mikehenry.graphqldemo.model.Student;
import com.mikehenry.graphqldemo.model.StudentCourse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private Set<StudentCourse> studentCourses;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.dob = student.getDob();
        this.address = student.getAddress();
        if (!student.getStudentCourses().isEmpty()) {
            this.studentCourses.addAll(student.getStudentCourses());
        }
    }
}
