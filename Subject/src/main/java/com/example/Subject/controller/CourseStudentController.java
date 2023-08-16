//package com.example.Subject.controller;
//
//import com.example.Subject.service.CourseStudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/CourseStudentController")
//public class CourseStudentController {
//    @Autowired
//    CourseStudentService courseStudentService;
//
//    @PostMapping("/api/CourseStudentController/create")
//    public ResponseEntity<?> createCourseStudent(@RequestBody CourseStudent courseStudent) {
//        CourseStudent newCourseStudent = courseStudentService.createCourseStudent(courseStudent);
//        return ResponseEntity.ok().body(newCourseStudent);
//    }
//}
