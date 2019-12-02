package org.patsimas.loginjwt.services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface MailService {

    void sendMessage(String from, String to, String subject, String text) throws MailException;

}
