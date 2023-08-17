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
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    CourseService courseService;


    @PostMapping("create")
    public ResponseEntity<CourseResponse> create(@RequestBody CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.create(courseRequest);
        return ResponseEntity.ok().body(courseResponse);
    }

    @GetMapping("/getAllCourse")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(courseService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        courseService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable long id, @RequestBody CourseRequest courseRequest) {
        Course course = courseService.update(id, courseRequest);
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
