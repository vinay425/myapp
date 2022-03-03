package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.SignUp;
import com.repository.SignUpRepo;

@Service
public class ServiceImp implements serviceInterface{
	
	@Autowired
	SignUpRepo signupRepo;

	@Override
	public String LoginCheck(String userName, String password)
	{
			List<SignUp> allData=(List<SignUp>) signupRepo.findAll();
			for(SignUp data:allData) 
				{
				if(userName.equals(data.getUserName()) && password.equals(data.getPassword()))
					return "login successfull";
				}
		return "Wrong UserName or Password";
	}

	@Override
	public String save(SignUp signup)
	{
		String userName=signup.getFirstName()+"@"+signup.getUserId();
		signup.setUserName(userName);
		signupRepo.save(signup);
		return "Saved successfully and the UserName is :"+userName;
	}

}
