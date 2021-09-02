package com.api.entity;

public class card {
    private String cno;
    private String name;
    private String grades;
    private int age;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "card{" +
                "cno='" + cno + '\'' +
                ", name='" + name + '\'' +
                ", grades='" + grades + '\'' +
                ", age=" + age +
                '}';
    }
}
