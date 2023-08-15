package com.example.Subject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String nameCourse;

    @OneToMany(mappedBy = "course")
    //rong trường hợp này, nó chỉ ra rằng một course có nhiều bản đánh giá khóa học (CourseRating).
    private List<Student> studentList;


}
