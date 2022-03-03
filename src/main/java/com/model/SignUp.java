package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="BasicData")
public class SignUp {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String password;
	private String userName;

}
