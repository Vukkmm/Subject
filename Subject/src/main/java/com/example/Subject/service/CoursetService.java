package com.example.Subject.service;

import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;

import java.util.List;

public interface CoursetService {
    Course create(Course course);
    List<Course> getAll();

    void delete(long id);

    Course update(long id, Course course);

    CourseResponse studentSameSubject(long id);


}
