package com.college.CollegeManagement.Repository;

import com.college.CollegeManagement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
