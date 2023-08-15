package com.example.Subject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;



    @OneToMany(mappedBy = "student")
    //rong trường hợp này, nó chỉ ra rằng một sinh viên (Student) có nhiều bản đánh giá khóa học (CourseRating).
    private List<CourseStudent> ratings;
}
