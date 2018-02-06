package com.ap.students.models;

import java.util.ArrayList;
import java.util.List;

public class StudentData {

    private static List<Student> studentList = new ArrayList<>();

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void removeStudent(int id) {
        Student studentToRemove = getStudentById(id);
        studentList.remove(studentToRemove);
    }

    public static Student getStudentById(int id) {
        Student student = null;
        for (Student s : studentList) {
            if (s.getId() == id) {
                student = s;
            }
        }
        return student;
    }
}
