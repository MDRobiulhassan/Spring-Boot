package com.hospital.HospitalManagement;

import com.hospital.HospitalManagement.Repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementApplicationTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
	void contextLoads() {
	}

}
