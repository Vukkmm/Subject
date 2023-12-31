package com.example.Subject.service.impl;


import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.entity.Student;
import com.example.Subject.repository.CourseRepository;
import com.example.Subject.repository.StudentRepository;
import com.example.Subject.service.CoursetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("course")
public class CoursetServiceImpl implements CoursetService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void delete(long id) {
        courseRepository.deleteCourse_id(id);
        Course subject = courseRepository.findById(id).orElse(null);
        if(Objects.nonNull(subject)) {
            courseRepository.delete(subject);
        }
    }

    @Override
    public Course update(long id, Course course) {
        Course course1 = courseRepository.findById(id).orElse(null);
        if (Objects.nonNull(course1)) {
            course1.setNameCourse(course.getNameCourse());
        }
        courseRepository.save(course1);
        return course1;
    }

    @Override
    public CourseResponse studentSameSubject(long id) {
        CourseResponse courseResponse = new CourseResponse();
        Course course = courseRepository.findById(id).orElse(null);
        if(Objects.nonNull(course)) {
            courseResponse.setNameCourse(course.getNameCourse());
        }
        List<String> nameStudents = new ArrayList<>();
        for (Long idStudent : courseRepository.searchStudent(id)) {
            Student student = studentRepository.findById(idStudent).orElse(null);
            if (Objects.nonNull(student)) {
                nameStudents.add(student.getName());
            }
        }
        courseResponse.setNameStudent(nameStudents);;

        return courseResponse;
    }

}
