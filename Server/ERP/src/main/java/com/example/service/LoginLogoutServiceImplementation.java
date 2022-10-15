package com.example.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.dao.LoginLogoutReposistory;
import com.example.model.LoginLogoutDetails;
import com.example.request.LoginRequest;
import com.example.request.LogoutRequest;

@Service
public class LoginLogoutServiceImplementation implements LoginLogoutService {

	@Autowired
	LoginLogoutReposistory loginLogoutReposistory;
	
	@Value("{$loginLogoutDuration}")
	private String duration;

	@Override
	public boolean login(LoginRequest loginrequest) {

		try {

		   // Local Time and HH:MM:SS Formatter
			LocalTime currentTime = LocalTime.now();
			DateTimeFormatter currentTimeFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
			LocalDate currentDate = LocalDate.now();

			// Local Date
			LoginLogoutDetails loginLogoutDetails = new LoginLogoutDetails();

			// Creating and Instilizing Login Logout Object
			loginLogoutDetails.setUserId(loginrequest.getUserId());
			loginLogoutDetails.setLoginDate(currentDate + "");
			loginLogoutDetails.setLoginTime(currentTime.format(currentTimeFormat));
			loginLogoutDetails.setLogoutDate(null);
			loginLogoutDetails.setLogoutTime(null);
			loginLogoutDetails.setDuration(null);
			loginLogoutDetails.setReason(null);
			loginLogoutReposistory.save(loginLogoutDetails);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean logout(LogoutRequest logoutRequest) {
	
		
		// Logout Date and Logout Time is Calculating
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter currentTimeFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalDate currentDate = LocalDate.now();
		
		LoginLogoutDetails loginLogoutDetails = loginLogoutReposistory.findByuserId(logoutRequest.getUserId());
		String loginTime = loginLogoutDetails.getLoginTime();
		String currentTimeUpdated = currentTime.format(currentTimeFormat);
		
		System.out.println(" Login Time " + loginTime + " Current Time " + currentTimeUpdated);
		
		
		return false;
        
		
		
		
		
		
	}

}
