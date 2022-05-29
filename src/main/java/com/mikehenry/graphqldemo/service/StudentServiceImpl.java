package com.mikehenry.graphqldemo.service;

import com.mikehenry.graphqldemo.model.Course;
import com.mikehenry.graphqldemo.model.Student;
import com.mikehenry.graphqldemo.model.StudentCourse;
import com.mikehenry.graphqldemo.repositiory.CourseRepository;
import com.mikehenry.graphqldemo.repositiory.StudentCourseRepository;
import com.mikehenry.graphqldemo.repositiory.StudentRepository;
import com.mikehenry.graphqldemo.request.CreateStudentRequest;
import com.mikehenry.graphqldemo.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public StudentResponse createStudent(final CreateStudentRequest createStudentRequest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(createStudentRequest.getDob(), dateTimeFormatter);
        Student student = new Student()
                .firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .address(createStudentRequest.getAddress())
                .dob(dateOfBirth);

        Student savedStudent = studentRepository.save(student);

        List<StudentCourse> studentCourses = new ArrayList<>();
        if (!createStudentRequest.getEnrolCourses().isEmpty()) {
            createStudentRequest.getEnrolCourses().forEach(enrolCourseRequest -> {
                Course course = courseRepository.findByCode(enrolCourseRequest.getCourse().name().toUpperCase());

                StudentCourse studentCourse = new StudentCourse();
                studentCourse.setStudent(savedStudent);
                studentCourse.setCourse(course);

                studentCourses.add(studentCourse);
            });
            studentCourseRepository.saveAll(studentCourses);
        }

        return new StudentResponse(savedStudent);
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
