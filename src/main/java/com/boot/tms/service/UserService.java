package com.boot.tms.service;

import com.boot.tms.dto.LoginRequest;
import com.boot.tms.dto.LoginResponse;
import com.boot.tms.model.User;

public interface UserService {
	
	User registerUser(User user);
	
	LoginResponse login(LoginRequest loginRequest);


}
