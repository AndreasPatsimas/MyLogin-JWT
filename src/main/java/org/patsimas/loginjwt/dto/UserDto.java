package org.patsimas.loginjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	private String username;

	private String password;

	private boolean active;

	private String email;

	private String authorities;
}
