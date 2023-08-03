package com.example.Subject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private String nameCourse;
    private List<String> nameStudent;

}
