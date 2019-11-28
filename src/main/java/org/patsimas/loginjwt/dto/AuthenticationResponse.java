package org.patsimas.loginjwt.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

    private final String jwt;
}
