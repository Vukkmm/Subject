package com.example.Subject.service;

import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Student;

import java.util.List;

public interface StudentService {

    StudentResponse create(StudentRequest studentRequest);
//
//    List<StudentResponse> getAll();
//
//
//    Boolean delete(long id);
//
//    StudentResponse update(long id, StudentRequest studentRequest);

//    List<StudentResponse> findSearchByName(String name);
}
