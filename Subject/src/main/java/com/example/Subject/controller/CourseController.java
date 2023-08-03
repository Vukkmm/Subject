package com.example.Subject.controller;

import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
//    @Autowired
//    CourseService courseService;
//
//    @PostMapping
//    public ResponseEntity<Course> create(@RequestBody Course course) {
//        Course course1 = courseService.create(course);
//        return ResponseEntity.ok().body(course1);
//    }
//    @GetMapping
//    public ResponseEntity<?> findAll() {
//
//        return ResponseEntity.ok().body(courseService.getAll());
//    }
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> delete(@PathVariable long id) {
//        courseService.delete(id);
//        return ResponseEntity.ok().body(null);
//    }
//    @PutMapping("{id}")
//    public ResponseEntity<?> update(@PathVariable long id,@RequestBody Course course) {
//        Course course1 = courseService.update(id,course);
//        return ResponseEntity.ok().body(course1);
//    }
//    @GetMapping("{id}")
//    public ResponseEntity<CourseResponse> studentSameSubject(@PathVariable long id) {
//        CourseResponse courseResponse = courseService.studentSameSubject(id);
//        return  ResponseEntity.ok().body(courseResponse);
//    }
}
