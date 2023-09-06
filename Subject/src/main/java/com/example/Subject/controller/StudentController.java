//package com.example.Subject.controller;
//
//import com.example.Subject.dto.request.StudentRequest;
//import com.example.Subject.dto.response.StudentResponse;
//import com.example.Subject.entity.Student;
//import com.example.Subject.service.StudentService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/students")
//public class StudentController {
//    @Autowired
//    StudentService studentService;
//
//    @PostMapping
//    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest studentRequest) {
//        StudentResponse studentResponse = studentService.create(studentRequest);
//        return ResponseEntity.ok().body(studentResponse);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<StudentResponse>> getAll() {
//        return ResponseEntity.ok().body(studentService.getAll());
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Boolean> delete(@PathVariable long id) {
//        studentService.delete(id);
//        return ResponseEntity.ok().body(null);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<?> update(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
//       try {
//           StudentResponse studentResponse = studentService.update(id, studentRequest);
//           return ResponseEntity.ok().body(studentResponse);
//       } catch (EntityNotFoundException ex){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy khóa học với id: " + id);
//        }
//    }
//}
//
//
