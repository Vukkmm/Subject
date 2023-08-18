package com.example.Subject.service.impl;


import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.dto.response.StudentInfoResponse;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.entity.Student;
import com.example.Subject.repository.CourseRepository;
import com.example.Subject.repository.StudentRepository;
import com.example.Subject.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
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

    private StudentInfoResponse createStudentInfoResponse(Student student) {
        StudentInfoResponse studentInfoResponse = new StudentInfoResponse();
        studentInfoResponse.setId(student.getId());
        studentInfoResponse.setStudentNames(student.getName());
        return studentInfoResponse;
    }

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
        List<StudentInfoResponse> studentInfoResponseList = new ArrayList<>();
        for (Student student : studentList) {
            studentInfoResponseList.add(createStudentInfoResponse(student));
        }
        courseResponse.setCourseName(courseRequest.getNameCourse());
        courseResponse.setStudentInfoResponses(studentInfoResponseList);
        return courseResponse;
    }

    @Override
    public List<CourseResponse> getAll() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();
        CourseResponse courseResponse = new CourseResponse();
        List<CourseResponse> courseResponses = new ArrayList<>();

        List<StudentInfoResponse> studentInfoResponseList = new ArrayList<>();
        for (Course course : courseList) {
            for (Student student : course.getStudentList()) {
                studentInfoResponseList.add(createStudentInfoResponse(student));
            }
            courseResponse.setCourseName(course.getNameCourse());
            courseResponse.setStudentInfoResponses(studentInfoResponseList);
            courseResponseList.add(courseResponse);
        }
        return courseResponseList;
    }

    @Override
    public Boolean delete(long id) {
        courseRepository.deleteCourse(id);
        Course subject = courseRepository.findById(id).orElse(null);
        if (Objects.nonNull(subject)) {
            courseRepository.delete(subject);
            return true;
        }
        return false;
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

            CourseResponse courseResponse = new CourseResponse();
            List<StudentInfoResponse> studentInfoResponseList = new ArrayList<>();
            for (Student student : studentList) {
                studentInfoResponseList.add(createStudentInfoResponse(student));
            }
            courseResponse.setCourseName(courseRequest.getNameCourse());
            courseResponse.setStudentInfoResponses(studentInfoResponseList);
            return courseResponse;
        } else {
            throw new EntityNotFoundException("Course with id " + id + " not found");
        }

    }



}
