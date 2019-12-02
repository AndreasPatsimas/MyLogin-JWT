package org.patsimas.loginjwt.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class ChangePasswordRequest {

    private String username;

    private String oldPassword;

    private String newPassword;
}
