package com.example.Subject.dao;

import com.example.Subject.entity.Course;

import java.util.List;

public interface CourseDao {
    void createCourse(int id, String name);

    Course findById(int id);

    List<Course> getListCourse();

    void deleteCourse(int id);

    void updateCourse(int id, String name);
}
