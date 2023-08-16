package com.example.Subject.service.impl;

import com.example.Subject.entity.Course;
//import com.example.Subject.entity.Student;
//import com.example.Subject.repository.CourseRepository;
//import com.example.Subject.repository.CourseStudentRepository;
//import com.example.Subject.repository.StudentRepository;
//import com.example.Subject.service.CourseStudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//@Service()
//public class CourseStudentServiceImpl implements CourseStudentService {
//
//    @Autowired
//    CourseStudentRepository courseStudentRepository;
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    CourseRepository courseRepository;
//
//    @Override
//    public CourseStudent createCourseStudent(CourseStudent courseStudent) {
//        //CourseStudent findCourseStudent = courseStudentRepository.findById(courseStudent.getId()).orElse(null);
//        Student student = studentRepository.findById(courseStudent.getStudent().getId()).orElse(null);
//        Course course = courseRepository.findById(courseStudent.getCourse().getId()).orElse(null);
//
//        if(Objects.nonNull(student) && Objects.nonNull(course)) {
//            CourseStudent newCourseStudent = courseStudentRepository.save(courseStudent);
//            return newCourseStudent;
//        }
//       // CourseStudent newCourseStudent = courseStudentRepository.save()
//        return null;
//    }
//}
