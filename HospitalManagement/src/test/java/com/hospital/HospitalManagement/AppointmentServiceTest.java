package com.hospital.HospitalManagement;

import com.hospital.HospitalManagement.entity.Appointment;
import com.hospital.HospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@SpringBootTest
public class AppointmentServiceTest {
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,30,00,00,00))
                .reason("Cancer")
                .status("Confirmed")
                .build();

        var createdAppointment = appointmentService.createAppointment(appointment,2L,2L);
        System.out.println(createdAppointment);
    }

//    @Test
//    public void deleteAppointment() {
//        appointmentService.deleteAppointment(1L);
//    }

    @Test
    public void getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
