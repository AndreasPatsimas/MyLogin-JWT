package org.patsimas.loginjwt.services;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

    void sendMessage(String from, String to, String subject, String text) throws MailException;

}
