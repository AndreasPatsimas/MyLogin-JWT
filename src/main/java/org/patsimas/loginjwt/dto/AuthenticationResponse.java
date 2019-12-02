package org.patsimas.loginjwt.dto;

import lombok.*;
import org.patsimas.loginjwt.enums.AuthenticationStatus;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

    private final String jwt;

    private AuthenticationStatus authenticationStatus;
}
