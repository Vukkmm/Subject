package com.example.Subject.service;

import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;

import java.util.List;

public interface CourseService {
    CourseResponse create(CourseRequest courseRequest);

    List<CourseResponse> getAll();

    void delete(long id);

    CourseResponse update(long id, CourseRequest courseRequest);
//
//    CourseResponse studentSameSubject(long id);


}
