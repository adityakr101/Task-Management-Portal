package com.boot.tms.serviceimpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.tms.dto.LoginRequest;
import com.boot.tms.dto.LoginResponse;
import com.boot.tms.exceptions.InvalidEmailException;
import com.boot.tms.exceptions.InvalidPasswordException;
import com.boot.tms.model.User;
import com.boot.tms.repository.UserRepository;
import com.boot.tms.service.UserService;
import com.boot.tms.util.JwtUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository repository;
	
	private final PasswordEncoder passwordEncoder;
	
	 private final JwtUtil jwtUtil;

	@Override
	public User registerUser(User user) {
		
        String password = user.getPassword();

        String encodedPassword = passwordEncoder.encode(password);

        user.setPassword(encodedPassword);
		return repository.save(user);
	}

	@Override
	public LoginResponse login(LoginRequest loginRequest) {

	    Optional<User> optional =
	            repository.findByEmail(loginRequest.getEmail());

	    if (optional.isEmpty()) {
	        throw new InvalidEmailException("Invalid Email");
	    }

	    User user = optional.get();

	    boolean passwordMatch = passwordEncoder.matches(
	            loginRequest.getPassword(),
	            user.getPassword()
	    );

	    if (!passwordMatch) {
	        throw new InvalidPasswordException("Invalid Password");
	    }

	    String token = jwtUtil.generateToken(user.getEmail());

	    return new LoginResponse(token);
	}
}
