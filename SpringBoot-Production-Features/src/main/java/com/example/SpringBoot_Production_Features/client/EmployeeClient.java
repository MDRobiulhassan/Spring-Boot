package com.example.SpringBoot_Production_Features.client;

import com.example.SpringBoot_Production_Features.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO createEmployee(EmployeeDTO employee);
}
