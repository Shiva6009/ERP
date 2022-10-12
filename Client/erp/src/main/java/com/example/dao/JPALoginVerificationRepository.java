package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Logindetails;

@Repository
public interface JPALoginVerificationRepository extends JpaRepository<Logindetails, Integer>{	

}
