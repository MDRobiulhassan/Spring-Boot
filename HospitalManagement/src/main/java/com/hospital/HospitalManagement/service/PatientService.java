package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.Repository.PatientRepository;
import com.hospital.HospitalManagement.entity.Insurance;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void deleteInsurance(Long patientId) {
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }
}
