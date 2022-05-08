package com.mikehenry.graphqldemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mikehenry.graphqldemo.common.AbstractAuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted = 0")
public class Student extends AbstractAuditableEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses;

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