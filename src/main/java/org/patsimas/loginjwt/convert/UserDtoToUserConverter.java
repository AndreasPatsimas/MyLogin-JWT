package org.patsimas.loginjwt.convert;

import org.patsimas.loginjwt.domain.Authority;
import org.patsimas.loginjwt.domain.User;
import org.patsimas.loginjwt.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .active((short) 1)
                .email(userDto.getEmail())
                .authorities(buildAuthorities())
                .build();
    }

    private List<Authority> buildAuthorities(){

        List<Authority> authorities = new ArrayList<>();

        authorities.add(Authority.builder()
                .id(1L)
                .description("ROLE_USER")
                .build());

        return authorities;
    }
}
