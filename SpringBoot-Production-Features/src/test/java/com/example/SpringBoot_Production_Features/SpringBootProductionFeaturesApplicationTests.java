package com.example.SpringBoot_Production_Features;

import com.example.SpringBoot_Production_Features.client.EmployeeClient;
import com.example.SpringBoot_Production_Features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringBootProductionFeaturesApplicationTests {

    @Autowired
    private EmployeeClient employeeClient;

    @Test
    @Order(3)
    public void getEmployees() {
        List<EmployeeDTO> employees = employeeClient.getEmployees();
        System.out.println(employees);
    }

    @Test
    @Order(2)
    public void getEmployeeById() {
        EmployeeDTO employee = employeeClient.getEmployeeById(1L);
        System.out.println(employee);
    }

    @Test
    @Order(1)
    public void createEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO(null,"Robiul","robiul@gmail.com",2, LocalDate.of(2020,12,01),true,"USER");
        EmployeeDTO employee = employeeClient.createEmployee(employeeDTO);
        System.out.println(employee);
    }
}
