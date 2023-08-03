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

    @EmbeddedId
    private Student_Course id;
    private String nameCourse;

//        @ManyToMany(mappedBy = "courses")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Student> students;
}
