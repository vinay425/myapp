package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleMail(String Email,String body,String Subject)
	{
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setFrom("MyApp");
		msg.setTo(Email);
		msg.setText(body);
		msg.setSubject(Subject);
		
		mailSender.send(msg); 
		System.out.println("Mail Sent...");
	}

}
