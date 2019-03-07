package usualstudent.coursework.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import usualstudent.coursework.database.service.MailSenderService;

/**
 * Created by PsihoZ on 05.11.2018.
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String username;
    @Override
    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);

    }
}
