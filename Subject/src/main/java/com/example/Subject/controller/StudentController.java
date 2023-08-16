package com.example.Subject.controller;

import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.entity.Student;
import com.example.Subject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.createStudent(studentRequest);
        return ResponseEntity.ok().body(student);

    }
    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok().body(studentService.getAllStudent());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body(null);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
        Student student = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok().body(student);
    }




}

//    @Autowired
//    StudentService studentService;
//
//    @PostMapping("/api/student/create")
//    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        Student newStudent = studentService.createStudent(student);
//        return ResponseEntity.ok().body(newStudent);
//    }
//
//}




//    @GetMapping("getAll")
//    public ResponseEntity<?> fillAll() {
//        return ResponseEntity.ok().body(studentService.getAll());
//    }

//    @PostMapping("createStudent")
//    public ResponseEntity<Student> create(@RequestBody StudentRequest studentRequest) {
//        Student student = studentService.create(studentRequest);
//        return ResponseEntity.ok().body(student);
//    }
//    @DeleteMapping("delete")
//    public ResponseEntity delete(@RequestParam("id") long id) {
//        studentService.delete(id);
//        return ResponseEntity.ok().body(null);
//    }
//    @PutMapping("{id}")
//    public ResponseEntity<Student> update(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
//        Student student = studentService.update(id, studentRequest);
//        return ResponseEntity.ok().body(student);
//    }
//    @GetMapping("searchSubjectById")
//    public ResponseEntity<?> searchId(@RequestParam("id") long id){
//        return ResponseEntity.ok().body(studentService.searchSubject(id));
//    }
//    @GetMapping("searchByName")
//    public ResponseEntity<?> findSearchByName(@RequestParam("name") String name) {
//        return ResponseEntity.ok().body(studentService.findSearchByName(name));
//    }

