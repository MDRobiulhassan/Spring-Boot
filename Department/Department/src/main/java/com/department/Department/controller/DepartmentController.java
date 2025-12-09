package com.department.Department.controller;

import com.department.Department.dto.DepartmentDTO;
import com.department.Department.response.DepartmentResponseDTO;
import com.department.Department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentDTO inputDepartment) {
        DepartmentResponseDTO departmentResponseDTO = departmentService.createDepartment(inputDepartment);
        return new ResponseEntity<>(departmentResponseDTO,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateDepartment(@RequestParam Long id,@RequestBody DepartmentDTO inputDepartment) {
        DepartmentResponseDTO departmentResponseDTO = departmentService.updateDepartment(id,inputDepartment);
        return ResponseEntity.ok(departmentResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDepartment(@RequestParam Long id) {
        boolean deleted = departmentService.deleteDepartment(id);
        if (deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/id")
    public ResponseEntity<?> getDepartmentById(@RequestParam Long id) {
        DepartmentResponseDTO departmentResponseDTO = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentResponseDTO);
    }
}
