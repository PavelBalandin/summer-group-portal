package com.summergroup.portal.dto;

import com.summergroup.portal.domain.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private String email;
    private Set<Role> roles;
}
