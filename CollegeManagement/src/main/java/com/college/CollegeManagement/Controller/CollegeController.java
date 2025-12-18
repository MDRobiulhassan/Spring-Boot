package com.college.CollegeManagement.Controller;

import com.college.CollegeManagement.Servie.CollegeService;
import com.college.CollegeManagement.entity.Professor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeService collegeService;

    @PostMapping("/assign/professor/subject")
    public void assignProfessorToSubject(@RequestParam Long professorId , @RequestParam Long subjectId) {
        collegeService.assignProfessorToSubject(professorId, subjectId);
    }

    @PostMapping("/assign/student/subject")
    public void assignStudentToSubject(@RequestParam Long studentId , @RequestParam Long subjectId) {
        collegeService.assignStudentToSubject(studentId, subjectId);
    }

    @PostMapping("/assign/professor/student")
    public void assignProfessorToStudent(@RequestParam Long studentId , @RequestParam Long professorId) {
        collegeService.assignProfessorToStudent(studentId, professorId);
    }
}
