package com.example.Subject.service.impl;

import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.entity.Student;
import com.example.Subject.repository.CourseRepository;

import com.example.Subject.repository.StudentRepository;
import com.example.Subject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentResponse create(StudentRequest studentRequest) {
        Student student = new Student();

        List<Course> courses = new ArrayList<>();
        for (Long id : studentRequest.getCourseIds()) {
            Course course = courseRepository.findById(id).orElse(null);
            if (Objects.nonNull(course)) {
                courses.add(course);
            }
        }
        student.setName(studentRequest.getName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setAddress(studentRequest.getAddress());
        student.setCourseList(courses);
        studentRepository.save(student);

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setNameStudent(student.getName());
        List<String> courseNames = new ArrayList<>();
        for (Course course : courses) {
            courseNames.add(course.getNameCourse());
        }
        studentResponse.setNameCourses(courseNames);

        return studentResponse;
    }

    @Override
    public List<StudentResponse> getAll() {
        List<Student> studentList = studentRepository.findAll();
        StudentResponse studentResponse = new StudentResponse();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : studentList) {
            studentResponse.setId(student.getId());
            studentResponse.setNameStudent(student.getName());
            List<String> courseNames = new ArrayList<>();
            for (Course course : student.getCourseList()) {
                courseNames.add(course.getNameCourse());
            }
            studentResponse.setNameCourses(courseNames);
            studentResponses.add(studentResponse);
        }
        return studentResponses;
    }

    @Override
    public void delete(long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (Objects.nonNull(student)) {
            studentRepository.deleteStudent(id);
            studentRepository.delete(student);
        }
    }

    @Override
    public StudentResponse update(long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).orElse(null);
        if (Objects.nonNull(student)) {
            studentRepository.deleteStudent(id);
            student.setName(studentRequest.getName());
            student.setPhoneNumber(studentRequest.getPhoneNumber());
            student.setAddress(studentRequest.getAddress());
            List<Course> courseList = new ArrayList<>();
            for (Long ids : studentRequest.getCourseIds()) {
                Course course = courseRepository.findById(ids).orElse(null);
                if (Objects.nonNull(course)) {
                    courseList.add(course);
                }
            }
            student.setCourseList(courseList);
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(id);
        studentResponse.setNameStudent(student.getName());
        List<String> courseNames = new ArrayList<>();
        for (Course course : student.getCourseList()) {
            courseNames.add(course.getNameCourse());
        }
        studentResponse.setNameCourses(courseNames);
        studentRepository.save(student);
        return studentResponse;
    }


//    @Override
//    public Student createStudent(Student student) {
//        Student newStudent = studentRepository.save(student);
//        return newStudent;
//    }


//    @Override
//    public List<Student> getAll() {
//        return studentRepository.findAll();
//    }


//    @Override
//    public Student create(StudentRequest studentRequest) {
//        Student student = new Student();
//        List<Course> courses = new ArrayList<>();
//        for (Long idCourse : studentRequest.getCourseIds()) {
//            Course course = courseRepository.findById(idCourse).orElse(null);
//            if (Objects.nonNull(course)) {
//                courses.add(course);
//            }
//        }
//        student.setName(studentRequest.getName());
//        student.setPhoneNumber(studentRequest.getPhoneNumber());
//        student.setAddress(studentRequest.getAddress());
//        student.setRatings(courses);
//        studentRepository.save(student);
//
//
//        return student;
//    }
//
//    @Override
//    public void delete(long id) {
//        Student student = studentRepository.findById(id).orElse(null);
//        if (Objects.nonNull(student)) {
//            studentRepository.deletestudent_course(id);
//            studentRepository.delete(student);
//        }
//    }
//
//    @Override
//    public Student update(long id, StudentRequest studentRequest) {
//        Student student = studentRepository.findById(id).orElse(null);
//        if (Objects.nonNull(student)) {
//            studentRepository.deletestudent_course(id);
//            student.setName(studentRequest.getName());
//            student.setPhoneNumber(studentRequest.getPhoneNumber());
//            student.setAddress(studentRequest.getAddress());
//            List<Course> courses = new ArrayList<>();
//            for (Long v : studentRequest.getCourseIds()) {
//                Course course = courseRepository.findById(v).orElse(null);
//                if (Objects.nonNull(course)) {
//                    courses.add(course);
//                }
//            }
//            student.setCourses(courses);
//
//        }
//        studentRepository.save(student);
//        return student;
//    }
//
//    @Override
//    public StudentResponse searchSubject(Long id) {
//        StudentResponse studentResponse = new StudentResponse();
//        Student student = studentRepository.findById(id).orElse(null);
//        if(Objects.nonNull(student)) {
//            studentResponse.setIdStudent(student.getId());
//            studentResponse.setNameStudent(student.getName());
//            List<String> nameList = new ArrayList<>();
//            for (Course course : student.getCourses()) {
//                nameList.add(course.getNameCourse());
//            }
//            studentResponse.setNameCourse(nameList);
//
//        }
//        return studentResponse;
//    }
//
//    @Override
//    public List<StudentResponse> findSearchByName(String name) {
//        List<StudentResponse> responses = new ArrayList<>();
//        for (Student student : studentRepository.findByNameStudent(name)) {
//            StudentResponse studentResponse = new StudentResponse();
//
//            List<String> stringList = new ArrayList<>();
//            for (Course course : student.getCourses()) {
//                stringList.add(course.getNameCourse());
//            }
//
//            studentResponse.setIdStudent(student.getId());
//            studentResponse.setNameStudent(student.getName());
//            studentResponse.setNameCourse(stringList);
//            responses.add(studentResponse);
//        }
//
//        //   List<Student> studentList = studentRepository.findByNameStudent(name);
//
//        return responses;
//    }
}
