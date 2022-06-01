package com.summergroup.portal.dto;

import com.summergroup.portal.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private Set<Role> roles;
}
