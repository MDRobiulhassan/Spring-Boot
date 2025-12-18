package com.hospital.HospitalManagement;

import com.hospital.HospitalManagement.Repository.PatientRepository;
import com.hospital.HospitalManagement.dto.BloodGroupStats;
import com.hospital.HospitalManagement.dto.PatientDTO;
import com.hospital.HospitalManagement.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void getAllPatients() {
        List<PatientDTO> patients = patientRepository.getAllPatients();

        for (PatientDTO patient : patients) {
            System.out.println(patient);
        }

        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();


    }

    @Test
    public void getAllPatientwithAppointment() {
        List<Patient> patients = patientRepository.getAllPatientwithAppointments();
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}
