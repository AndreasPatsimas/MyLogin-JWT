package org.patsimas.loginjwt.dto;

import lombok.*;
import org.patsimas.loginjwt.enums.ForgotPasswordStatus;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class ForgotPasswordResponse {

    private ForgotPasswordStatus forgotPasswordStatus;

    private String resetKeyPassword;
}
