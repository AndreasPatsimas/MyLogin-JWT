package org.patsimas.loginjwt.dto;

import lombok.*;
import org.patsimas.loginjwt.enums.ChangePasswordStatus;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class ChangePasswordResponse {

    private ChangePasswordStatus changePasswordStatus;
}
