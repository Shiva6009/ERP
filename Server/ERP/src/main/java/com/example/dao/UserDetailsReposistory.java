package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;


@Repository
public interface UserDetailsReposistory extends JpaRepository<User, Long>{	
	User findByuserName(String userName);
}
