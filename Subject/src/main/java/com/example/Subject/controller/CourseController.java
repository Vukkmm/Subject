package com.example.Subject.controller;

import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;

import com.example.Subject.entity.Student;
import com.example.Subject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

   @Autowired
    CourseService courseService;



    @PostMapping("create")
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest) {
        Course course = courseService.createCourse(courseRequest);
        return ResponseEntity.ok().body(course);
    }
    @GetMapping("/getAllCourse")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok().body(courseService.getAllCourse());
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().body(null);
    }
    @PutMapping()
    public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody CourseRequest courseRequest) {
        Course course = courseService.updateCourse(id, courseRequest);
        return ResponseEntity.ok().body(course);
    }

//    @GetMapping("getAll")
//    public ResponseEntity<?> fillAll() {
//
//        return ResponseEntity.ok().body(coursetService.getAll());
//    }
//    @DeleteMapping("delete")
//    public ResponseEntity<?> delete(@RequestParam("id") long id) {
//        coursetService.delete(id);
//        return ResponseEntity.ok().body(null);
//    }
//    @PutMapping("update")
//    public ResponseEntity<?> update(@RequestParam("id") long id,@RequestBody Course course) {
//        Course course1 = coursetService.update(id,course);
//        return ResponseEntity.ok().body(course1);
//    }
//    @GetMapping("}")
//    public ResponseEntity<CourseResponse> studentSameSubject(@RequestParam("id") long id) {
//        CourseResponse courseResponse = coursetService.studentSameSubject(id);
//        return  ResponseEntity.ok().body(courseResponse);
//    }
}
