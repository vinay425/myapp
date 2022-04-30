package com;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BasicappApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(BasicappApplication.class, args);
		
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "Logged in successfully";
	}
	@RequestMapping("/")
	public String Default()
	{
		return "SpringBoot Project";
	}
	
	

}
