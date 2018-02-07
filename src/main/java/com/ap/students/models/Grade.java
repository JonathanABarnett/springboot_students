package com.ap.students.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "level")
    private String level;

    @OneToMany
    @JoinColumn(name = "grade_id")
    List<Student> studentList = new ArrayList<>();

    public Grade() {}

    public Grade(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
