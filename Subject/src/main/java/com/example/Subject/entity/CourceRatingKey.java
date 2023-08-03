package com.example.Subject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
public class CourceRatingKey implements Serializable {
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "course_id")
    Long courseId;

}
