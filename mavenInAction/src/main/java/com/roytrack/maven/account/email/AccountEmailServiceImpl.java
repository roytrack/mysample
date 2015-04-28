package com.roytrack.maven.account.email;

import com.roytrack.maven.exception.AccountEmailException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * Created by roytrack on 2015/4/28.
 */
public class AccountEmailServiceImpl implements AccountEmailService{
    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }

    private JavaMailSender javaMailSender;
    private String systemEmail;



    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom(systemEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlText);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new AccountEmailException("send mail failed.",e);
        }


    }
}
