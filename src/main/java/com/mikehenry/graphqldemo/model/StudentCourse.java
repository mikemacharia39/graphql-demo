package com.mikehenry.graphqldemo.model;

import com.mikehenry.graphqldemo.common.AbstractAuditableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse extends AbstractAuditableEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "active")
    private Integer active = 1;

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
