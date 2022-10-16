package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.LoginRequest;
import com.example.request.LogoutRequest;
import com.example.service.LoginLogoutService;

@CrossOrigin("*")
@RequestMapping("/api/v2")
@RestController
public class LoginLogoutController {

	@Autowired
	LoginLogoutService loginLogoutService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testAPI() {
		return "Server Running Sucessfully Keep Coding!!";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean login(@RequestBody LoginRequest loginRequest) {
		return loginLogoutService.login(loginRequest);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public boolean logout(@RequestBody LogoutRequest logoutRequest) {
		return loginLogoutService.logout(logoutRequest);
	}
	
	@RequestMapping(value = "/logoutconfirm" , method = RequestMethod.POST)
	public boolean logoutConfirm(@RequestBody LogoutRequest logoutRequest) {
		return loginLogoutService.logoutConfirmation(logoutRequest);
	}
	
	
}
