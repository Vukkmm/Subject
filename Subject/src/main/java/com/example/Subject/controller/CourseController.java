//package com.example.Subject.controller;
//
//import com.example.Subject.dto.request.CourseRequest;
//import com.example.Subject.dto.response.CourseResponse;
//
//import com.example.Subject.service.CourseService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;

//@RestController
//@RequestMapping("/api/v1/courses")
//public class CourseController {
//
//    @Autowired
//    CourseService courseService;
//
//
//    @PostMapping
//    public ResponseEntity<CourseResponse> create(@RequestBody CourseRequest courseRequest) {
//        CourseResponse courseResponse = courseService.create(courseRequest);
//        return ResponseEntity.ok().body(courseResponse);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<CourseResponse>> getAll() {
//        return ResponseEntity.ok().body(courseService.getAll());
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity delete(@PathVariable long id) {
//        courseService.delete(id);
//        return ResponseEntity.ok().body(null);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<?> update(@PathVariable long id, @RequestBody CourseRequest courseRequest) {
//        try {
//            CourseResponse courseResponse = courseService.update(id, courseRequest);
//            return ResponseEntity.ok().body(courseResponse);
//        } catch (EntityNotFoundException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy khóa học với id: " + id);
//        }
//    }
//
//
//}
