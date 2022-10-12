package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.JPALoginVerificationRepository;
import com.example.model.IncomingLoginDetails;
import com.example.model.Logindetails;

@Service
public class MasterServiceImplementation implements MasterService {

	@Autowired
	JPALoginVerificationRepository jPALoginVerificationRepository;

	@Override
	public boolean loginVerification(IncomingLoginDetails incomingLoginData) {

		Optional<Logindetails> receivedObject = jPALoginVerificationRepository.findById(incomingLoginData.getUserid());
		if (receivedObject.isEmpty()) {
			return false;
		} else {
			if (receivedObject.get().getUserpassword().equals(incomingLoginData.getUserpassword())
					&& receivedObject.get().isUserisactive()) {
				return true;
			} else {
				return false;
			}

		}

	}

}
