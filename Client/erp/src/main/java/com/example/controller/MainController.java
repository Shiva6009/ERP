package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.IncomingLoginDetails;
import com.example.service.MasterService;


@CrossOrigin("*")
@RestController
public class MainController {

	@Autowired
	MasterService masterService;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String testAPI() {
		return "Server Running Sucessfully Keep Coding!!";
	}

	@RequestMapping(value = "loginverification", method = RequestMethod.POST)
	public boolean loginVerification(@RequestBody IncomingLoginDetails loginData) {
		return masterService.loginVerification(loginData);

	}
	
	
}
