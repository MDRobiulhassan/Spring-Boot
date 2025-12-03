package com.springweb.SpringWeb.controller;

import com.springweb.SpringWeb.Service.EmployeeService;
import com.springweb.SpringWeb.dto.EmployeeDTO;
import com.springweb.SpringWeb.entity.EmployeeEntity;
import com.springweb.SpringWeb.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId")  Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeService.createEmployee(inputEmployee);
    }
}
