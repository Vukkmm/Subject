package com.example.Subject.repository;

import com.example.Subject.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Transactional
    @Modifying
    @Query(value = "Delete from student_object WHERE course_id = ?1", nativeQuery = true)
    void deleteCourse_id(Long courseId);

    @Query(value = "SELECT student_id FROM student_object WHERE course_id = ?1", nativeQuery = true)
    List<Long> searchStudent(Long id);
}
