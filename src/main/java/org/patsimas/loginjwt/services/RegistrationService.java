package org.patsimas.loginjwt.services;

import org.patsimas.loginjwt.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    void register(UserDto userDto);
}
