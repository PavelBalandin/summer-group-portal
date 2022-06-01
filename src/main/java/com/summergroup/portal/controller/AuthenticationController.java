package com.summergroup.portal.controller;

import com.summergroup.portal.dto.RegistrationRequest;
import com.summergroup.portal.dto.UserDto;
import com.summergroup.portal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class AuthenticationController {
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/v1/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody RegistrationRequest registrationRequest) {
        log.info("Register user {}", registrationRequest.getUsername());
        return new ResponseEntity<>(userService.saveUser(registrationRequest), HttpStatus.CREATED);
    }

}
