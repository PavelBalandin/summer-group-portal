package com.summergroup.portal.controller;

import com.summergroup.portal.dto.UserDto;
import com.summergroup.portal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        log.trace("Getting user list");
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getByLogin(@PathVariable String username) {
        log.trace("Getting user by username");
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }
}
