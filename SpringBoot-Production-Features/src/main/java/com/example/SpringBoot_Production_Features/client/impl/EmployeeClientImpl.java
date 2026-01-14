package com.example.SpringBoot_Production_Features.client.impl;

import com.example.SpringBoot_Production_Features.client.EmployeeClient;
import com.example.SpringBoot_Production_Features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
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

    @Override
    public List<EmployeeDTO> getEmployees() {
        try {
            List<EmployeeDTO> employees =
                    restClient.get()
                            .uri("/employees")
                            .retrieve()
                            .body(new ParameterizedTypeReference<List<EmployeeDTO>>() {
                            });
            return employees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        try {
            EmployeeDTO employee = restClient.get()
                    .uri("employees/{id}", id)
                    .retrieve()
                    .body(new ParameterizedTypeReference<EmployeeDTO>() {
                    });
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        try {
            ResponseEntity<EmployeeDTO> employeeDTO = restClient.post()
                    .uri("/employees")
                    .body(employee)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, ((request, response) ->
                            System.out.println(response.getBody())))
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            return employeeDTO.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
