package com.service;

import com.model.SignUp;

public interface serviceInterface {
	
	public String LoginCheck(String userName,String password);
	
	public String save(SignUp signup);

}
