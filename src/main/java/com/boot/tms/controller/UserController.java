package com.boot.tms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.tms.dto.LoginRequest;
import com.boot.tms.dto.LoginResponse;
import com.boot.tms.model.User;
import com.boot.tms.service.UserService;
import com.boot.tms.util.ResponseStructure;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	
	private final UserService service;
	
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
		User u=service.registerUser(user);
		
		ResponseStructure<User> rs=new ResponseStructure<User>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("User object created successfully");
		rs.setData(u);
		
		return new ResponseEntity<ResponseStructure<User>>(rs,HttpStatus.CREATED);
	}
	
    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {

        LoginResponse response = service.login(loginRequest);

        ResponseStructure<LoginResponse> rs = new ResponseStructure<LoginResponse>();

        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Login successful");
        rs.setData(response);

        return new ResponseEntity<ResponseStructure<LoginResponse>>(rs, HttpStatus.OK);
    }
}
