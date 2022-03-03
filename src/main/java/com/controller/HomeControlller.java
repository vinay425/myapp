package com.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.SignUp;
import com.repository.SignUpRepo;
import com.service.ServiceImp;

@RestController
@RequestMapping("myapp")//localhost:80/myapp
public class HomeControlller {
	
	@Autowired
	ServiceImp serviceImp;
	
	@GetMapping("/{userName}")
	public String getCredentials(@PathVariable("userName") String userName)
								 //@PathVariable("password") String password)
	{
		return "username :"+userName;
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("userName") String userName,@RequestParam("password") String password)
	{
		ResponseEntity<String> responseEntity=null;
		String value=serviceImp.LoginCheck(userName, password);
		if(value.equalsIgnoreCase("login successfull"))
			responseEntity=new ResponseEntity<String>("User Logged in Successfully ",HttpStatus.ACCEPTED);
		else
			responseEntity=new ResponseEntity<String>("Wrong credentials ",HttpStatus.NOT_ACCEPTABLE);
		return responseEntity;
	}
	
	@PostMapping
	public String saveDetails(@RequestBody SignUp signup)
	{
		String value=serviceImp.save(signup);
		return value;
	}

}
