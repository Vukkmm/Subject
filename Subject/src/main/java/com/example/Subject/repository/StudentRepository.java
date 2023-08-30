package com.example.Subject.repository;

import com.example.Subject.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from course_student WHERE student_id = ?1", nativeQuery = true)
    void deleteStudent(Long studentId);

//    @Query(value = "SELECT * FROM students WHERE name LIKE %?1%", nativeQuery = true)
//    List<Student> findByNameStudent(String keyword);
}
