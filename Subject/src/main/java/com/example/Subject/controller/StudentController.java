package com.example.Subject.controller;

import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.entity.Student;
import com.example.Subject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;
//    @GetMapping
//    public ResponseEntity<?> findAll() {
//        return ResponseEntity.ok().body(studentService.getAll());
//    }

//    @PostMapping
//    public ResponseEntity<Student> create(@RequestBody StudentRequest studentRequest) {
//        Student student = studentService.create(studentRequest);
//        return ResponseEntity.ok().body(student);
//    }
//    @DeleteMapping("{id}")
//    public ResponseEntity delete(@PathVariable long id) {
//        studentService.delete(id);
//        return ResponseEntity.ok().body(null);
//    }
//    @PostMapping("{id}")
//    public ResponseEntity<Student> update(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
//        Student student = studentService.update(id, studentRequest);
//        return ResponseEntity.ok().body(student);
//    }
//    @GetMapping("{id}")
//    public ResponseEntity<?> searchId(@PathVariable long id){
//        return ResponseEntity.ok().body(studentService.searchSubject(id));
//    }
//    @GetMapping("{name}")
//    public ResponseEntity<?> findSearchByName(@PathVariable String name) {
//        return ResponseEntity.ok().body(studentService.findSearchByName(name));
//    }
}
