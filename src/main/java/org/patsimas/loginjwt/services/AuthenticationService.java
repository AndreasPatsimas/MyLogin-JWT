package org.patsimas.loginjwt.services;

import org.patsimas.loginjwt.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws Exception;

    ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest);

    ForgotPasswordResponse forgotPassword(ForgotPasswordRequest forgotPasswordRequest);
}
