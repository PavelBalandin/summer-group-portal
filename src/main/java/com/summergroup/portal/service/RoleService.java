package com.summergroup.portal.service;

import com.summergroup.portal.domain.Role;
import com.summergroup.portal.exception.ResourceNotFoundException;
import com.summergroup.portal.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getByName(String name) {
        log.debug("Get role by name: {}", name);
        return roleRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Role> getRolesByNames(List<String> names) {
        log.debug("Get roles by names: {}", names);
        return roleRepository.findRolesByNameIn(names);
    }
}
