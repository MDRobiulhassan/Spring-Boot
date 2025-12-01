package com.springweb.SpringWeb.controller;

import com.springweb.SpringWeb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId")  Long id){
        return new EmployeeDTO(id,"Robiul Hassan","robiul@gmail.com",26, LocalDate.of(2025,9,15),true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,@RequestParam(required = false) String sortBy){
        return "Employee with "+age+" Sort By "+sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(26L);
        return employeeDTO;
    }
}
