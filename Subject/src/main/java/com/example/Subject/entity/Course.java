package com.example.Subject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String nameCourse;
//  private List<Student> studentList;


}
