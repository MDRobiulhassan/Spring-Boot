package com.example.SpringBoot_Production_Features.client.impl;

import com.example.SpringBoot_Production_Features.client.EmployeeClient;
import com.example.SpringBoot_Production_Features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    Logger logger = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getEmployees() {

//        logger.error("error log");
//        logger.warn("warn log");
//        logger.info("info log");
//        logger.debug("debug log");
//        logger.trace("trace log");

        logger.info("Fetching all employees from Employee Service");

        try {
            List<EmployeeDTO> employees =
                    restClient.get()
                            .uri("/employees")
                            .retrieve()
                            .body(new ParameterizedTypeReference<List<EmployeeDTO>>() {
                            });
            logger.info("Fetched {} employees successfully", employees.size());
            logger.debug("Employee list: {}", employees);
            return employees;
        } catch (Exception e) {
            logger.error("Error while fetching employees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        logger.info("Fetching employee with ID: {}", id);

        try {
            EmployeeDTO employee = restClient.get()
                    .uri("employees/{id}", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<EmployeeDTO>() {
                    });
            logger.info("Fetched employee successfully: {}", employee);
            return employee;
        } catch (Exception e) {
            logger.error("Error while fetching employee with ID: {}", id, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        logger.info("Creating new employee: {}", employee);

        try {
            ResponseEntity<EmployeeDTO> employeeDTO = restClient.post()
                    .uri("/employees")
                    .body(employee)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, ((request, response) ->
                            System.out.println(response.getBody())))
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            logger.info("Employee created successfully: {}", employeeDTO.getBody());
            return employeeDTO.getBody();
        } catch (Exception e) {
            logger.error("Error while creating employee: {}", employee, e);
            throw new RuntimeException(e);
        }
    }

}
