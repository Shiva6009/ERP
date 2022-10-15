package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.LoginLogoutDetails;

@Repository
public interface LoginLogoutReposistory extends JpaRepository<LoginLogoutDetails, Integer>{
	
	public LoginLogoutDetails findByuserId(int userId);
}
