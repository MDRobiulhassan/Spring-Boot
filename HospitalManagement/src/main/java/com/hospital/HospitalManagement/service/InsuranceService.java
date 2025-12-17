package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.Repository.InsuranceRepository;
import com.hospital.HospitalManagement.Repository.PatientRepository;
import com.hospital.HospitalManagement.entity.Insurance;
import com.hospital.HospitalManagement.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public Insurance createInsurance(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return insurance;
    }
}
