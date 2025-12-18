package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.Repository.PatientRepository;
import com.hospital.HospitalManagement.entity.Insurance;
import com.hospital.HospitalManagement.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void deleteInsurance(Long patientId) {
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }

    @Transactional
    public List<Patient> getAllPatientwithAppointment() {
        List<Patient> patients = patientRepository.getAllPatientwithAppointments();
        return patients;
    }
}
