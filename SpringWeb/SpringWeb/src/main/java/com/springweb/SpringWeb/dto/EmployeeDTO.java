package com.springweb.SpringWeb.dto;

import com.springweb.SpringWeb.annotations.EmployeeValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name Cannot be Blank")
    private String name;

    @NotBlank(message = "Email Can't Be Empty")
    @Email
    private String email;

    @Min(18)
    @Max(80)
    private Integer age;

    @PastOrPresent(message = "Joining Date Must be Past or Present")
    private LocalDate joinDate;

    private Boolean isActive;

    @NotBlank(message = "Role Can't be Empty")
//    @Pattern(regexp = "(ADMIN|USER)")
    @EmployeeValidation
    private String role;
}
