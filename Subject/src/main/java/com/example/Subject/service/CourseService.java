package com.example.Subject.service;

import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;

import java.util.List;

public interface CourseService {
    CourseResponse create(CourseRequest courseRequest);

    List<CourseResponse> getAll();

    Boolean delete(int id);

    CourseResponse update(int id, CourseRequest courseRequest);

//    CourseResponse studentSameSubject(long id);


}
