package org.patsimas.loginjwt.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendMessage(String from, String to, String subject, String text) throws MailException {

        log.info("Sending email message to {} started", to);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);

        log.info("Sending email message completed");
    }
    
}
