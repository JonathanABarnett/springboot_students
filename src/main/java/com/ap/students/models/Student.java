package com.ap.students.models;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private int id;
    private static int idCount = 10000;

    public Student(String firstName, String lastName, int age, int id) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;

    }

    private Student() {
        id = idCount;
        idCount++;
    }

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
}
