package com.example.SpringSecurity.utils;

import com.example.SpringSecurity.entity.enums.Permission;
import com.example.SpringSecurity.entity.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SpringSecurity.entity.enums.Permission.*;
import static com.example.SpringSecurity.entity.enums.Role.*;

public class PermissionMapping {

    private static final Map<Role, Set<Permission>> rolePermissionMapping = Map.of(
            USER,Set.of(USER_VIEW,POST_VIEW),
            CREATOR,Set.of(POST_CREATE,USER_UPDATE,POST_UPDATE),
            ADMIN,Set.of(POST_CREATE,USER_UPDATE,POST_UPDATE,USER_CREATE,POST_DELETE,USER_DELETE)
    );

    public static Set<SimpleGrantedAuthority> getAuthoritiesForRole(Role role) {
        return rolePermissionMapping.get(role).stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
