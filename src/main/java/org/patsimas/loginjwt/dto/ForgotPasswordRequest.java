package org.patsimas.loginjwt.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class ForgotPasswordRequest {

    private String username;

    private String email;
}
