package com.example.Subject.service;

import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseRequest courseRequest);
    List<Course> getAllCourse();

    void deleteCourse(long id);
    Course updateCourse(long id, CourseRequest courseRequest);
//
//    CourseResponse studentSameSubject(long id);


}
