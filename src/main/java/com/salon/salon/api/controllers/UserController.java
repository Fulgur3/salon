package com.salon.salon.api.controllers;


import com.salon.salon.domain.dto.LoginDto;
import com.salon.salon.domain.dto.UserDto;
import com.salon.salon.service.SecurityService;
import com.salon.salon.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
@Slf4j
public class UserController {
private final SecurityService securityService;
private final UserService userService;


@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto data){
    securityService.login(data.getLogin(), data.getPassword());
    log.debug("Logged new user:" +data.getLogin());
    return new ResponseEntity<>(UserDto.convert(userService.getUserByEmail(data.getLogin())),new HttpHeaders(), HttpStatus.OK);
}
@PostMapping("/register")
    public ResponseEntity<?> newUser(@RequestBody @Valid UserDto user){
    userService.createUser(user);
    log.debug("registered new user: "+ user.getEmail() + " " + user.getUserName());
    securityService.login(user.getLogin(), user.getPassword());
    return new ResponseEntity<>(UserDto.convert(userService.getUserByEmail(user.getEmail())), new HttpHeaders(), HttpStatus.OK);
}

}
