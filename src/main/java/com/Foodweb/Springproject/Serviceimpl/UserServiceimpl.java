package com.Foodweb.Springproject.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Repositry.UserRepositry;
import com.Foodweb.Springproject.Service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserRepositry userRepo;

	@Override
	public void signup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User login(String un, String psw) {
		
		return userRepo.findByUsernameAndPassword(un, psw);
		
	}
	

	@Override
	public User authenticate(String username, String password) {
		
		return userRepo.findByUsernameAndPassword(username, password);
	 }

	
	
	
	@Override
	public boolean checkUserExists(String username) {
		
		return userRepo.existsByUsername(username); 
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get(); 
	}

	
	 
	
	

}
