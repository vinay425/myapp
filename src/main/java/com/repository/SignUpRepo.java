package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.model.SignUp;

public interface SignUpRepo extends CrudRepository<SignUp,Integer> {

}
