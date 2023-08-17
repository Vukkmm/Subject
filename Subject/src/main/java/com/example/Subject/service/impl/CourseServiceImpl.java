package com.example.Subject.service.impl;


import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.entity.Student;
import com.example.Subject.repository.CourseRepository;
import com.example.Subject.repository.StudentRepository;
import com.example.Subject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public CourseResponse create(CourseRequest courseRequest) {
        Course course = new Course();
        List<Student> studentList = new ArrayList<>();
        for (Long id : courseRequest.getStudentIds()) {
            Student student = studentRepository.findById(id).orElse(null);
            if (Objects.nonNull(student)) {
                studentList.add(student);
            }
        }
        course.setNameCourse(courseRequest.getNameCourse());
        course.setStudentList(studentList);
        courseRepository.save(course);

        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setNameCourse(courseRequest.getNameCourse());
        List<String> nameStudents = new ArrayList<>();
        for (Student student : studentList) {
            nameStudents.add(student.getName());
        }
        courseResponse.setNameStudent(nameStudents);
        return courseResponse;
    }

    @Override
    public List<CourseResponse> getAll() {
        List<Course> courseList = courseRepository.findAll();
        CourseResponse courseResponse = new CourseResponse();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courseList) {
            courseResponse.setNameCourse(course.getNameCourse());
            List<String>  nameStudents = new ArrayList<>();
            for (Student student : course.getStudentList()) {
                nameStudents.add(student.getName());
            }
            courseResponse.setNameStudent(nameStudents);
            courseResponses.add(courseResponse);
        }
        return courseResponses;
    }

    @Override
    public void delete(long id) {
        courseRepository.deleteCourse(id);
        Course subject = courseRepository.findById(id).orElse(null);
        if (Objects.nonNull(subject)) {
            courseRepository.delete(subject);
        }
    }

    @Override
    public CourseResponse update(long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).orElse(null);
        if (Objects.nonNull(course)) {
            courseRepository.deleteCourse(id);
            course.setNameCourse(course.getNameCourse());
            List<Student> studentList = new ArrayList<>();
            for (Long ids : courseRequest.getStudentIds()) {
                Student student = studentRepository.findById(ids).orElse(null);
                if (Objects.nonNull(student)) {
                    studentList.add(student);
                }
            }
            course.setStudentList(studentList);
        }
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setNameCourse(courseRequest.getNameCourse());
        List<String> nameStudents = new ArrayList<>();
        for (Student student : course.getStudentList()) {
            nameStudents.add(student.getName());
        }
        courseResponse.setNameStudent(nameStudents);
        courseRepository.save(course);
        return courseResponse;
    }


//
//    @Override
//    public List<Course> getAll() {
//        return courseRepository.findAll();
//    }
//
//    @Override
//    public void deleteCourse(long id) {
//        courseRepository.deleteCourse_id(id);
//        Course subject = courseRepository.findById(id).orElse(null);
//        if(Objects.nonNull(subject)) {
//            courseRepository.delete(subject);
//        }
//    }
//
//    @Override
//    public Course updateCourse(long id, Course course) {
//        Course course1 = courseRepository.findById(id).orElse(null);
//        if (Objects.nonNull(course1)) {
//            course1.setNameCourse(course.getNameCourse());
//        }
//        courseRepository.save(course1);
//        return course1;
//    }
//
//    @Override
//    public CourseResponse studentSameSubject(long id) {
//        CourseResponse courseResponse = new CourseResponse();
//        Course course = courseRepository.findById(id).orElse(null);
//        if(Objects.nonNull(course)) {
//            courseResponse.setNameCourse(course.getNameCourse());
//        }
//        List<String> nameStudentList = new ArrayList<>();
//        for (Long idStudent : courseRepository.searchStudent(id)) {
//            Student student = studentRepository.findById(idStudent).orElse(null);
//            if (Objects.nonNull(student)) {
//                nameStudentList.add(student.getName());
//            }
//        }
//        courseResponse.setNameStudent(nameStudentList);;
//
//        return courseResponse;
//    }

}
