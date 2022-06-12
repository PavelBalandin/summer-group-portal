package com.summergroup.portal.controller;

import com.summergroup.portal.dto.RegistrationRequest;
import com.summergroup.portal.dto.UserDTO;
import com.summergroup.portal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/v1/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        log.info("Register user {}", registrationRequest.getUsername());
        return new ResponseEntity<>(userService.create(registrationRequest), HttpStatus.CREATED);
    }

}
