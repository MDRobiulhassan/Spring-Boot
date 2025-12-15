package com.hospital.HospitalManagement.dto;

import lombok.Data;

@Data
public class PatientInfo {

    private Long id;
    private String name;
    private String email;

    public PatientInfo(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
