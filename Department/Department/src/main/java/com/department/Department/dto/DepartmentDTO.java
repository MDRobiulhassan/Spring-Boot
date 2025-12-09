package com.department.Department.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDTO {

    @NotBlank(message = "Title Cannot be Blank")
    private String title;

    private boolean isActive;
}
