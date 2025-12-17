package com.hospital.HospitalManagement.service;

import com.hospital.HospitalManagement.Repository.AppointmentRepository;
import com.hospital.HospitalManagement.Repository.DoctorRepository;
import com.hospital.HospitalManagement.Repository.PatientRepository;
import com.hospital.HospitalManagement.entity.Appointment;
import com.hospital.HospitalManagement.entity.Doctor;
import com.hospital.HospitalManagement.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    @Transactional
    public Appointment createAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }

    @Transactional
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
