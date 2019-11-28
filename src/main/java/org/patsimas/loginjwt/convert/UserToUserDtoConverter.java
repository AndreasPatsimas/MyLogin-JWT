package org.patsimas.loginjwt.convert;


import org.patsimas.loginjwt.domain.User;
import org.patsimas.loginjwt.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

	@Override
	public UserDto convert(User user) {
		
		return UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.password(user.getPassword())
				.active(user.getActive() == 1? true : false)
				.authorities(buildAuthorities(user))
				.build();
	}
	
	private String buildAuthorities(User user){
		
		StringJoiner authorities = new StringJoiner(",");

		user.getAuthorities().forEach(authority -> {
			
			authorities.add(authority.getDescription());
		});		
		return authorities.toString();
	}

}
