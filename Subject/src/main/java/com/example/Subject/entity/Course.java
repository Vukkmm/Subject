package com.example.Subject.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String nameCourse;
    private List<Student> studentList;


}
