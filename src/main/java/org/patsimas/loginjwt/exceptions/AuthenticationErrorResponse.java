package org.patsimas.loginjwt.exceptions;

import lombok.*;
import org.patsimas.loginjwt.enums.AuthenticationStatus;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationErrorResponse {

    private int errorCode;

    private HttpStatus status;

    private String message;

    private AuthenticationStatus authenticationStatus;
}
