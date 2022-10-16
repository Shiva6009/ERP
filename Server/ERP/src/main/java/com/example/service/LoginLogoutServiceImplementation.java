package com.example.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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

	@Value("${loginLogoutDuration}")
	private Double duration;

	private static String AUTO_LOGOUT_MSG = "Auto Logout";
	private static String AUTO_LOGOUT_TIME = "23:59:59";

	@Override
	public boolean login(LoginRequest loginrequest) {

		try {

			// Local Time and HH:MM:SS Formatter
			LocalTime currentTime = LocalTime.now();
			DateTimeFormatter currentTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
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

		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter currentTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate currentDate = LocalDate.now();
		LoginLogoutDetails loginLogoutDetails = loginLogoutReposistory.findByUserId(logoutRequest.getUserId());

		String loginTime = loginLogoutDetails.getLoginTime();
		String currentTimeUpdated = currentTime.format(currentTimeFormat);

		List<Long> calculatedResult = calculateHourMinutesSeconds(currentTimeUpdated, loginTime);
		long totalMinutes = ((calculatedResult.get(0 * 60)) + calculatedResult.get(1)) + calculatedResult.get(2);
		if (totalMinutes >= (duration * 60)) {
			loginLogoutDetails.setLogoutDate(currentDate + "");
			loginLogoutDetails.setLogoutTime(currentTime.format(currentTimeFormat));
			loginLogoutDetails.setDuration(
					calculatedResult.get(0) + ":" + calculatedResult.get(1) + ":" + calculatedResult.get(2));
			loginLogoutDetails.setReason(null);
			loginLogoutReposistory.save(loginLogoutDetails);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean autoLogout() {

		System.out.println(" Log Off ");
		LocalDate currentDate = LocalDate.now();
		List<LoginLogoutDetails> loginLogoutDetails = loginLogoutReposistory
				.findByLoginDateAndLogoutTime(currentDate + "", null);
		for (LoginLogoutDetails elem : loginLogoutDetails) {
			System.out.println(" User ID " + elem.getUserId());
			List<Long> calculatedResult = calculateHourMinutesSeconds(AUTO_LOGOUT_TIME, elem.getLoginTime());
			elem.setLogoutDate(currentDate + "");
			elem.setDuration(calculatedResult.get(0) + ":" + calculatedResult.get(1) + ":" + calculatedResult.get(2));
			elem.setLogoutTime(AUTO_LOGOUT_TIME);
			elem.setReason(AUTO_LOGOUT_MSG);
			loginLogoutReposistory.save(elem);
		}
		return false;
	}

	private List<Long> calculateHourMinutesSeconds(String currentTimeUpdated, String loginTime) {

		List<Long> hourMinutesSeconds = new ArrayList<>();
		LocalTime localCurrentTime = LocalTime.of(Integer.parseInt(currentTimeUpdated.substring(0, 2)),
				Integer.parseInt(currentTimeUpdated.substring(3, 5)),
				Integer.parseInt(currentTimeUpdated.substring(6, 8)));
		LocalTime localLoginTime = LocalTime.of(Integer.parseInt(loginTime.substring(0, 2)),
				Integer.parseInt(loginTime.substring(3, 5)), Integer.parseInt(loginTime.substring(6, 8)));
		hourMinutesSeconds.add(ChronoUnit.HOURS.between(localLoginTime, localCurrentTime));
		hourMinutesSeconds.add(ChronoUnit.MINUTES.between(localLoginTime, localCurrentTime) % 60);
		hourMinutesSeconds.add(ChronoUnit.SECONDS.between(localLoginTime, localCurrentTime) % 60);
		return hourMinutesSeconds;
	}

	@Override
	public boolean logoutConfirmation(LogoutRequest logoutRequest) {

		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter currentTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate currentDate = LocalDate.now();
		LoginLogoutDetails loginLogoutDetails = loginLogoutReposistory.findByUserId(logoutRequest.getUserId());
		String loginTime = loginLogoutDetails.getLoginTime();
		String currentTimeUpdated = currentTime.format(currentTimeFormat);

		List<Long> calculatedResult = calculateHourMinutesSeconds(currentTimeUpdated, loginTime);
		long totalMinutes = ((calculatedResult.get(0 * 60)) + calculatedResult.get(1)) + calculatedResult.get(2);
		if (totalMinutes >= (duration * 60)) {
			loginLogoutDetails.setLogoutDate(currentDate + "");
			loginLogoutDetails.setLogoutTime(currentTime.format(currentTimeFormat));
			loginLogoutDetails.setDuration(
					calculatedResult.get(0) + ":" + calculatedResult.get(1) + ":" + calculatedResult.get(2));
			loginLogoutDetails.setReason(logoutRequest.getReason());
			loginLogoutReposistory.save(loginLogoutDetails);
			return true;

		} else {
			return false;
		}
	}

}
