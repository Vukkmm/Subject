package com.example.Subject.dao;

import com.example.Subject.entity.Student;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface StudentDao {
    Student create(int id, String name, String phoneNumber, String address, List<Integer> courseIds);

    Student findById(int id);

    List<Student> getListStudent();
}
