package com.example.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.service.LoginLogoutService;

@Component
public class AutoLogoutScheduler {

	@Autowired
	LoginLogoutService loginLogoutService;
	
	@Scheduled(cron="0 0 0 * * *")
	public void autoLogoutSchleduer() {
	    loginLogoutService.autoLogout();
	}
}
