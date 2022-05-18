package com.mikehenry.graphqldemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "course")
@SQLDelete(sql = "UPDATE course SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted = 0")
public class Course implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code")
    private String code;

    @NotNull
    @Column(name = "name")
    private String name;

    public Course code(String code) {
        this.code = code;
        return this;
    }

    public Course name(String name) {
        this.name = name;
        return this;
    }
}
