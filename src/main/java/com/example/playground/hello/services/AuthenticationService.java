package com.example.playground.hello.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authinticate(String userName, String password) {
		boolean isUserNameValid = userName.equals("hamada");
		boolean isPaswordValid = password.equals("hamada");
		return isUserNameValid && isPaswordValid;
	}
}
