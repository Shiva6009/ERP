package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.LoginLogoutDetails;

@Repository
public interface LoginLogoutReposistory extends JpaRepository<LoginLogoutDetails, Integer>{
	
	public LoginLogoutDetails findByUserId(int userId);
	public List<LoginLogoutDetails> findByLoginDateAndLogoutTime(String loginDate , String logoutTime);
}
