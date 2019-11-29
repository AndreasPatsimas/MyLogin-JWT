package org.patsimas.loginjwt.services;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.loginjwt.dto.AuthenticationRequest;
import org.patsimas.loginjwt.dto.AuthenticationResponse;
import org.patsimas.loginjwt.exceptions.AuthenticationFailedException;
import org.patsimas.loginjwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@PropertySource(value = "classpath:application.properties")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${email.address.to}")
    private String emailAddressTo;

    @Value("${email.address.from}")
    private String emailAddressFrom;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MailService mailService;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) throws Exception {

        log.info("Authentication processs begins");

        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e){

            throw new AuthenticationFailedException("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        mailService.sendMessage(emailAddressFrom, emailAddressTo, "ap", "ap");

        log.info("Authentication processs completed");

        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }
}
