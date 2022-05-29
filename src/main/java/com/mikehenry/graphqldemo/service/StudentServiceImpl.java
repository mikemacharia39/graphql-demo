package com.mikehenry.graphqldemo.service;

import com.mikehenry.graphqldemo.model.Student;
import com.mikehenry.graphqldemo.repositiory.StudentCourseRepository;
import com.mikehenry.graphqldemo.repositiory.StudentRepository;
import com.mikehenry.graphqldemo.request.CreateStudentRequest;
import com.mikehenry.graphqldemo.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student()
                .firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .address(createStudentRequest.getAddress())
                .dob(createStudentRequest.getDob());

        Student savedStudent = studentRepository.save(student);



    }

    @Transactional
    @Override
    public StudentResponse getStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            throw new RuntimeException("No student found");
        }

        return new StudentResponse(optionalStudent.get());
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> studentResponses = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> studentResponses.add(new StudentResponse(student)));
        return studentResponses;
    }
}
