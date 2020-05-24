package com.ming.mailsender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
class MailsenderApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("1045576349@qq.com");
        message.setTo("1078166319@qq.com");
        message.setCc("944436077@qq.com");
        message.setBcc("961077602@qq.com");
        message.setSentDate(new Date());
        message.setText("这是测试邮件的正文");
        javaMailSender.send(message);
    }

}
