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
		
		return new UserDto(user.getId(), user.getUsername(), user.getPassword(), 
				user.getActive() == 1? true : false, buildAuthorities(user));
	}
	
	private String buildAuthorities(User user){
		
		StringJoiner authorities = new StringJoiner(",");

		user.getAuthorities().forEach(authority -> {
			
			authorities.add(authority.getDescription());
		});		
		return authorities.toString();
	}

}
