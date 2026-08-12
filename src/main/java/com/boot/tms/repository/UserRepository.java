package com.boot.tms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.tms.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	Optional<User> findByEmail(String email);

}
