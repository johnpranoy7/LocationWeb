package com.johnp.locationweb.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailImpl implements IEmail {
	
	@Autowired
	JavaMailSender sender;
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);
			System.out.println("inside try catch of sedn email");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		sender.send(message);
	}

		
}
