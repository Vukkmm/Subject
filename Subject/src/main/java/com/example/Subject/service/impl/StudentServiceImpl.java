package com.example.Subject.service.impl;

import com.example.Subject.dao.CourseDao;
import com.example.Subject.dao.StudentDao;
import com.example.Subject.dao.impl.CourseDaoImpl;
import com.example.Subject.dao.impl.StudentDaoImpl;
import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.entity.Student;



import com.example.Subject.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();


    private Student createStudentFromRequest(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setAddress(studentRequest.getAddress());
        return studentRepository.save(student);
    }

    private List<Course> getCoursesFromIds(List<Long> courseIds) {
        List<Course> courses = new ArrayList<>();
        for (Long id : courseIds) {
            Course course = courseRepository.findById(id).orElse(null);
            if (Objects.nonNull(course)) {
                courses.add(course);
            }
        }
        return courses;
    }

    private StudentResponse createStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setNameStudent(student.getName());
        List<String> courseNames = new ArrayList<>();
        for (Course course : student.getCourseList()) {
            courseNames.add(course.getNameCourse());
        }
        studentResponse.setNameCourses(courseNames);
        return studentResponse;
    }

    @Override
    public StudentResponse create(StudentRequest studentRequest) {
        Student student = createStudentFromRequest(studentRequest);
        List<Course> courses = getCoursesFromIds(studentRequest.getCourseIds());
        student.setCourseList(courses);
        studentRepository.save(student);
        return createStudentResponse(student);
    }
//
//    @Override
//    public List<StudentResponse> getAll() {
//        List<Student> studentList = studentRepository.findAll();
//        //StudentResponse studentResponse = new StudentResponse();
//        List<StudentResponse> studentResponses = new ArrayList<>();
//        for (Student student : studentList) {
//            StudentResponse studentResponse = createStudentResponse(student);
//            studentResponses.add(studentResponse);
//        }
//        return studentResponses;
//    }
//
//    @Override
//    public Boolean delete(long id) {
//        Student student = studentRepository.findById(id).orElse(null);
//        if (Objects.nonNull(student)) {
//            studentRepository.deleteStudent(id);
//            studentRepository.delete(student);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public StudentResponse update(long id, StudentRequest studentRequest) {
//        Student student = studentRepository.findById(id).orElse(null);
//        if (Objects.nonNull(student)) {
//            studentRepository.deleteStudent(id);
//            student.setName(studentRequest.getName());
//            student.setPhoneNumber(studentRequest.getPhoneNumber());
//            student.setAddress(studentRequest.getAddress());
//            List<Course> courseList = getCoursesFromIds(studentRequest.getCourseIds());
//            student.setCourseList(courseList);
//            studentRepository.save(student);
//            return createStudentResponse(student);
//        } else {
//            throw new EntityNotFoundException("Course with id " + id + " not found");
//        }
//
//    }
//
//
//    }
