package com.Foodweb.Springproject.Service;


import com.Foodweb.Springproject.Model.User;

public interface UserService {
	void signup(User user);
	User login(String un, String psw);
	
    User authenticate(String username, String password);
    
    
	boolean checkUserExists(String username); 
	
	User getById(int id);
   
	
}
