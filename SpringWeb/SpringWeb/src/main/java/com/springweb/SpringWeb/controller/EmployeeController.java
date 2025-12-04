package com.springweb.SpringWeb.controller;

import com.springweb.SpringWeb.Service.EmployeeService;
import com.springweb.SpringWeb.dto.EmployeeDTO;
import com.springweb.SpringWeb.entity.EmployeeEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId")  Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        EmployeeDTO employeeDTO = employeeService.createEmployee(inputEmployee);
        return new ResponseEntity<>(employeeDTO,HttpStatus.CREATED);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId,employeeDTO));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId){
        boolean deleted = employeeService.deleteEmployee(employeeId);
        if(deleted)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployee(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployee(updates,employeeId);
        if (employeeDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
