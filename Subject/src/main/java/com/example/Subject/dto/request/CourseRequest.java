package com.example.Subject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

@AllArgsConstructor
public class CourseRequest {
    private int id;
    private String nameCourse;
}
