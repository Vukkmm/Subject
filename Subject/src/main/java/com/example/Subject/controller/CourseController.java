package com.example.Subject.controller;


import com.example.Subject.dto.request.CourseRequest;
import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponse> create(@RequestBody CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.create(courseRequest);
        return ResponseEntity.ok().body(courseResponse);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAll() {
        return ResponseEntity.ok().body(courseService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        courseService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CourseRequest courseRequest) {
            CourseResponse courseResponse = courseService.update(id, courseRequest);
            return ResponseEntity.ok().body(courseResponse);
    }
}
