package com.example.Subject.controller;

import com.example.Subject.dto.request.StudentRequest;
import com.example.Subject.dto.response.StudentResponse;
import com.example.Subject.entity.Student;
import com.example.Subject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.create(studentRequest);
        return ResponseEntity.ok().body(studentResponse);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(studentService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        studentService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable long id, @RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse = studentService.update(id, studentRequest);
        return ResponseEntity.ok().body(studentResponse);
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

