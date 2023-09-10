package com.example.Subject.dao;

import com.example.Subject.entity.Student;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface StudentDao {
    void createStudent(int id, String name, String phoneNumber, String address, int courseId);

    Student findById(int id);

    List<Student> getListStudent();
}
