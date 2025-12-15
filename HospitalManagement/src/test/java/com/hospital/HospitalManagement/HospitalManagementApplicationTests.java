package com.hospital.HospitalManagement;

import com.hospital.HospitalManagement.Repository.PatientRepository;
import com.hospital.HospitalManagement.dto.PatientDTO;
import com.hospital.HospitalManagement.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HospitalManagementApplicationTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
	void contextLoads() {
	}

}
