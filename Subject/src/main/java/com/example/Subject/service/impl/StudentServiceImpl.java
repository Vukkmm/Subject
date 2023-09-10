package com.example.Subject.service.impl;


import com.example.Subject.dao.CourseDao;
import com.example.Subject.dao.StudentDao;
import com.example.Subject.dao.impl.CourseDaoImpl;
import com.example.Subject.dao.impl.StudentDaoImpl;
import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public StudentResponse create(StudentRequest studentRequest) {
        StudentResponse studentResponse = new StudentResponse();
        studentDao.createStudent(studentRequest.getId(), studentRequest.getName(), studentRequest.getPhoneNumber(), studentRequest.getAddress(), studentRequest.getCourseId());
        Course course = courseDao.findById(studentRequest.getId());
        if(Objects.nonNull(course)) {
            studentResponse.setNameCourses(course.getNameCourse());
        } else {
            return null;
        }
        studentResponse.setNameStudent(studentRequest.getName());
        return studentResponse;
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
    }
