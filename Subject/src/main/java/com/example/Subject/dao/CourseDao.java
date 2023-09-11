package com.example.Subject.dao;

import com.example.Subject.entity.Course;

import java.util.List;

public interface CourseDao {
    void create(int id, String name);

    Course findById(int id);

    List<Course> getListCourse();

    void delete(int id);

    void update(int id, String name);
}
