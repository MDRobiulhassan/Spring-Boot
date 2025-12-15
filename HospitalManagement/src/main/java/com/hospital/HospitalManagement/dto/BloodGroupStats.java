package com.hospital.HospitalManagement.dto;

import com.hospital.HospitalManagement.enums.BloodGroup;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroup bloodGroupType;
    private final Long count;
}