package com.hospital.HospitalManagement.entity;

import com.hospital.HospitalManagement.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointment = new HashSet<>();
}
