package com.example.Subject.service;

import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student create(StudentRequest studentRequest);

    void delete(long id);

    Student update(long id, StudentRequest studentRequest);

    StudentResponse searchSubject(Long id);

    List<StudentResponse> findSearchByName(String name);
}
