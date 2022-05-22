package com.mikehenry.graphqldemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mikehenry.graphqldemo.common.AbstractAuditableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted = 0")
public class Student extends AbstractAuditableEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "dob")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "deleted")
    private Integer deleted = 1;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentCourse> studentCourses = new ArrayList<>();

    public Student firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student dob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public Student address(String address) {
        this.address = address;
        return this;
    }
}
