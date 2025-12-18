package com.college.CollegeManagement.Servie;

import com.college.CollegeManagement.Repository.AdmissionRecordRepository;
import com.college.CollegeManagement.Repository.ProfessorRepository;
import com.college.CollegeManagement.Repository.StudentRepository;
import com.college.CollegeManagement.Repository.SubjectRepository;
import com.college.CollegeManagement.entity.Professor;
import com.college.CollegeManagement.entity.Student;
import com.college.CollegeManagement.entity.Subject;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CollegeService {

    private  final ProfessorRepository professorRepository;
    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Transactional
    public void assignProfessorToSubject(Long subjectId, Long professorId) {
        Professor professor = professorRepository.findById(professorId).orElseThrow(()->new RuntimeException("professor not found"));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->new RuntimeException("subject not found"));

        subject.setProfessor(professor);
        professor.getSubjects().add(subject);
    }

    @Transactional
    public void assignStudentToSubject(Long studentId, Long subjectId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->new RuntimeException("subject not found"));

        student.getSubjects().add(subject);
        subject.getStudents().add(student);
    }

    @Transactional
    public void assignProfessorToStudent(Long studentId, Long professorId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));
        Professor professor = professorRepository.findById(professorId).orElseThrow(()->new RuntimeException("professor not found"));

        student.getProfessors().add(professor);
        professor.getStudents().add(student);
    }
}
