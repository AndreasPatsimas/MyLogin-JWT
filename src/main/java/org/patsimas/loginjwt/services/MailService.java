package org.patsimas.loginjwt.services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface MailService {

    void sendMessage(String from, String to, String subject, String text) throws MailException;

    void sendMessageUsingTemplate(String from, String to, String subject, SimpleMailMessage template, String... templateArgs);

    void sendMessageWithAttachment(String from, String to, String subject, String text, String pathToAttachment)
            throws MessagingException;
}
