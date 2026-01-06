package com.example.SpringSecurity.dto;

import com.example.SpringSecurity.entity.enums.Permission;
import com.example.SpringSecurity.entity.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignupDTO {
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;
    private Set<Permission> permissions;
}
