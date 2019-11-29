package org.patsimas.loginjwt.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.loginjwt.dto.AuthenticationRequest;
import org.patsimas.loginjwt.exceptions.AuthenticationErrorResponse;
import org.patsimas.loginjwt.exceptions.AuthenticationFailedException;
import org.patsimas.loginjwt.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createAuthenticateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        log.info("Authenticate user {}", authenticationRequest.getUsername());

        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<AuthenticationErrorResponse> exceptionHandler(Exception ex) {

        AuthenticationErrorResponse authenticationErrorResponse = AuthenticationErrorResponse.builder()
                .errorCode(HttpStatus.NOT_ACCEPTABLE.value())
                .status(HttpStatus.NOT_ACCEPTABLE)
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<AuthenticationErrorResponse>(authenticationErrorResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
