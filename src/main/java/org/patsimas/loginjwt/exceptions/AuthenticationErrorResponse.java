package org.patsimas.loginjwt.exceptions;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationErrorResponse {

    private int errorCode;

    private String message;
}
