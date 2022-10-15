package com.example.service;

import com.example.request.LoginRequest;
import com.example.request.LogoutRequest;

public interface LoginLogoutService {

	public boolean login(LoginRequest loginrequest);
	public boolean logout(LogoutRequest logoutRequest);

}
