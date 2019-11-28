package org.patsimas.loginjwt.services;

import org.patsimas.loginjwt.dto.AuthenticationRequest;
import org.patsimas.loginjwt.dto.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws Exception;
}
