package com.ap.students.models;



import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Size(min = 2, max = 20, message = "Please enter student's first name.")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 20, message = "Please enter student's last name.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Range(min = 5, max = 99)
    @Column(name = "age")
    private int age;

    @ManyToOne
    private Grade grade;


    public Student(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    public Student() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
