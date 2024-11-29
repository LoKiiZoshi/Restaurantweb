package com.Foodweb.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Service.UserService;



@Controller
public class AdminController {
	
	
	
     @Autowired
	 private UserService userService;
	
	 @GetMapping("/AdminLogin")
	 public String getLogin() {
		 return "AdminLoginForm";  
	} 
	
	 
	
	
	// Handles POST request for Admin login, authenticates user, and redirects to appropriate view based on role.
	
	
	 @PostMapping("/adminlogin")
	    public ModelAndView adminLogin(@ModelAttribute User user, Model model) {
	        User authenticatedUser = null;

	        try {
	         
	          authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());
	        } catch (Exception e) {
	            e.printStackTrace();
	            ModelAndView errorView = new ModelAndView("AdminLoginForm");
	            errorView.addObject("msg", "An error occurred during login. Please try again.");
	            return errorView;
	        }

	        if (authenticatedUser != null && "ROLE_ADMIN".equals(authenticatedUser.getRole())) {
	            ModelAndView successView = new ModelAndView("DashboardForm");
	            successView.addObject("admin", authenticatedUser);  
	            
	         
	             
	            
	            return successView;
	        } else {
	            ModelAndView failureView = new ModelAndView("AdminLoginForm");
	            failureView.addObject("msg", "Please enter correct username and password");
	            return failureView; 
	        }
	    }
	}

