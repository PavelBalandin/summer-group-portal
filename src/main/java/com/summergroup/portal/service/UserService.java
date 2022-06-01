package com.summergroup.portal.service;

import com.summergroup.portal.domain.User;
import com.summergroup.portal.dto.RegistrationRequest;
import com.summergroup.portal.dto.UserDto;
import com.summergroup.portal.exception.ResourceNotFoundException;
import com.summergroup.portal.exception.ResourcesAlreadyExistsException;
import com.summergroup.portal.mapper.UserMapper;
import com.summergroup.portal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    public List<UserDto> getUsers() {
        log.debug("Getting list of users");
        List<User> userList = userRepository.findAll();
        return userMapper.toDtoList(userList);
    }

    public UserDto getUserByUsername(String username) {
        log.debug("Getting user by username", username);
        User user = userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
        return userMapper.toDto(user);
    }

    @Transactional
    public UserDto saveUser(RegistrationRequest registrationRequest) {
        User user = userMapper.registrationRequestToEntity(registrationRequest);
        user.setRoles(Set.of(roleService.getByName("ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            log.error("User with {} username already exists", user.getUsername());
            throw new ResourcesAlreadyExistsException("User with the same username already exists");
        }
        if (userRepository.findByUsername(user.getEmail()).isPresent()) {
            log.error("User with {} email already exists", user.getEmail());
            throw new ResourcesAlreadyExistsException("User with the same email already exists");
        }

        log.info("Saving user {} to database", user.getUsername());
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

}
