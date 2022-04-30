package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.EmailSenderService;
import com.model.SignUp;
import com.repository.SignUpRepo;
import com.service.ServiceImp;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("myapp")//localhost:80/myapp
public class HomeControlller {
	
	@Autowired
	ServiceImp serviceImp;
	
	@Autowired
	EmailSenderService emailSender;
	
	
	@RequestMapping("/")
	public String Default()
	{
		return "SpringBoot Project";
	}	
	@GetMapping("/{userName}")
	public String getCredentials(@PathVariable("userName") String userName)
	{
		return "username :"+userName;
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("email") String email)
	{
		Random random = new Random();
		Integer number = random.nextInt(9999);
		String code=number.toString();
		emailSender.sendSimpleMail(email,code,"Verification Code");
	return code;
	}
	@PostMapping
	public String saveDetails(@RequestBody SignUp signup)
	{
		String value=serviceImp.save(signup);
		return value;
	}

}
