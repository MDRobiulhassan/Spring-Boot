package com.department.Department.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonPropertyOrder({"id", "title", "active", "createdAt"})
public class DepartmentResponseDTO {

    private Long id;
    private String title;
    private boolean isActive;

    @JsonFormat(pattern = "hh-mm-ss dd-MM-yyyy")
    private LocalDateTime createdAt;
}

