package com.example.Subject.dao;

import com.example.Subject.entity.Student;

public interface StudentDao {
    Student create(Long id, String name, String phoneNumber, String address);
}
