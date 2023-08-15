package com.example.Subject.repository;

import com.example.Subject.entity.CourseStudent;
import com.example.Subject.entity.CourseStudentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStudentRepository extends JpaRepository<CourseStudent, CourseStudentKey> {
}
