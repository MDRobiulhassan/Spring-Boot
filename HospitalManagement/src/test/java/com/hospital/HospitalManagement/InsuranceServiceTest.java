package com.hospital.HospitalManagement;

import com.hospital.HospitalManagement.entity.Insurance;
import com.hospital.HospitalManagement.service.InsuranceService;
import com.hospital.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceServiceTest {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private PatientService patientService;

    @Test
    public void createInsurance() {
        Insurance insurance = Insurance.builder()
                .policyNumber("12345")
                .provider("IFIC")
                .validUntil(LocalDateTime.of(2030,01,01,00,00,00))
                .build();

        var updatedInsurance = insuranceService.createInsurance(insurance,1L);
        System.out.println(updatedInsurance);

//        patientService.deleteInsurance(1L);

        var patient = insuranceService.deleteInsurance(1L);
        System.out.println(patient);
    }
}
