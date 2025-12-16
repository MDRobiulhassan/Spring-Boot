package com.hospital.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 100)
    private String specialization;

    @Column(nullable = false,length = 100,unique = true)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointment = new HashSet<>();

    @OneToOne(mappedBy = "headDoctor")
    private Department department;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments = new HashSet<>();
}
