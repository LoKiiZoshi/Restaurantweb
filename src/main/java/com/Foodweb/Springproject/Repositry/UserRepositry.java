package com.Foodweb.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.User;
public interface UserRepositry extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String un, String psw);
	boolean existsByUsername(String username);

}
