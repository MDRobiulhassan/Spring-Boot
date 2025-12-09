package com.department.Department.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Entity
@Table(name="department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private boolean isActive;
    private LocalDateTime createdAt;
}
