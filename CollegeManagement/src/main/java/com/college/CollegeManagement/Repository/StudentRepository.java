package com.college.CollegeManagement.Repository;

import com.college.CollegeManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
