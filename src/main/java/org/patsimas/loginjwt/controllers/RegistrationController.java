package org.patsimas.loginjwt.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.loginjwt.dto.UserDto;
import org.patsimas.loginjwt.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws Exception{

        log.info("Register user {}", userDto.getUsername());

        registrationService.register(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
