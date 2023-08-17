package com.example.Subject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String nameCourse;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList;


}
