package com.example.Subject.service.impl;

import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.entity.CourseStudent;
import com.example.Subject.entity.Student;
import com.example.Subject.repository.CourseRepository;
import com.example.Subject.repository.CourseStudentRepository;
import com.example.Subject.repository.StudentRepository;
import com.example.Subject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("api/student")
public class StudentServiceImpl  implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseStudentRepository courseStudentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Student createStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    CourseStudentRepository courseRakingRepository;
//


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
