package usualstudent.coursework.database.service;

import org.springframework.stereotype.Service;

/**
 * Created by PsihoZ on 05.11.2018.
 */

@Service
public interface MailSenderService {
    public void send(String emailTo, String subject, String message);

}
