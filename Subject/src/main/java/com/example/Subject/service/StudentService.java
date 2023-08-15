package com.example.Subject.service;

import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent (Student student);
//    List<Student> getAll();

//
//    void deleteUser(long id);
//
//    Student updateUser(long id, StudentRequest studentRequest);
//
//    Student createStudent(StudentRequest studentRequest);
//
//    void deleteStudent(long id);
//
//    Student updateStudent(long id, StudentRequest studentRequest);
//
//    StudentResponse searchSubject(Long id);
//
//    List<StudentResponse> findSearchByName(String name);
}
