package org.patsimas.loginjwt;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.patsimas.loginjwt.dto.AuthenticationRequest;
import org.patsimas.loginjwt.dto.ChangePasswordRequest;
import org.patsimas.loginjwt.dto.ForgotPasswordRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"spring.application.name=AuthenticationControllerTest",
        "spring.jmx.default-domain=AuthenticationControllerTest"})
public class AuthenticationControllerTest extends BasicWiremockTest {

    private static final String USERNAME = "andreas";

    private static final String PASSWORD = "aris1914";

    private static final String WRONG_PASSWORD = "aris191";

    private static final String EMAIL = "andreas-patsim@hotmail.com";

    @Test
    public void authenticateSuccess() throws Exception {

        AuthenticationRequest authenticationRequest = AuthenticationRequest
                .builder()
                .username(USERNAME)
                .password(PASSWORD)
                .build();

        this.mockMvc.perform(
                post(CONTEXT_PATH + "/authenticate").contextPath(CONTEXT_PATH)
                        .content(asJsonString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void authenticateFailed() throws Exception {

        AuthenticationRequest authenticationRequest = AuthenticationRequest
                .builder()
                .username(USERNAME)
                .password(WRONG_PASSWORD)
                .build();

        this.mockMvc.perform(
                post(CONTEXT_PATH + "/authenticate").contextPath(CONTEXT_PATH)
                        .content(asJsonString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable())
                .andExpect(content().contentType("application/json"));
    }

    @Ignore
    @Test
    public void changePasswordSuccess() throws Exception {

        ChangePasswordRequest changePasswordRequest = ChangePasswordRequest.builder()
                .username(USERNAME)
                .oldPassword(PASSWORD)
                .newPassword("aris")
                .build();

        this.mockMvc.perform(
                post(CONTEXT_PATH + "/changePassword").contextPath(CONTEXT_PATH)
                        .content(asJsonString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Ignore
    @Test
    public void forgotPasswordSuccess() throws Exception {

        ForgotPasswordRequest forgotPasswordRequest = ForgotPasswordRequest.builder()
                .username(USERNAME)
                .email(EMAIL)
                .build();

        this.mockMvc.perform(
                post(CONTEXT_PATH + "/forgotPassword").contextPath(CONTEXT_PATH)
                        .content(asJsonString(forgotPasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
