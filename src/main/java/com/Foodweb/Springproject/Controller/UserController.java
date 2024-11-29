package com.Foodweb.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Service.ProductService;

import com.Foodweb.Springproject.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService prodService;

	@GetMapping({ "/login", "/" })
	public String getLogin() { 

		return "LoginForm";

	}
	@GetMapping("/Signup")
	public String getsignup() {
		return "SignupForm";
	}
	
	
	

     //	@PostMapping("/register")
    //	public String postSingnup(@ModelAttribute User user) {
   //		userService.signup(user);
  //		return"LoginForm";
 //	} 
	
		
	
	// Handles POST request for new user registration and not user exists.

	  @PostMapping("/newuserregister")
	    public ModelAndView newUserRegister(@ModelAttribute User user) {
		  
		  
	 // Check if user name already exists in the database
	        boolean exists = this.userService.checkUserExists(user.getUsername());

	        
	        if (!exists) {
	            System.out.println("Username: " + user.getUsername());
	            user.setRole("ROLE_NORMAL");
	            this.userService.signup(user);
	            System.out.println("New user created with password: " + user.getPassword());
	            ModelAndView successView = new ModelAndView("LoginForm");
	            return successView;
	        } else {
	            System.out.println("New user not created - username taken: " + user.getUsername());
	            ModelAndView failureView = new ModelAndView("SignupForm");
	            failureView.addObject("msg", user.getUsername() + " is taken. Please choose a different username.");
	            return failureView;
	            
	            
	        }
	    }
	
 
	  
	  

	// Handles POST request for user login.
	  
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user,Model model,HttpSession session) {
		
		User u = userService.login(user.getUsername(), user.getPassword());
		if(u != null) {
			
			session.setAttribute("validuser", u);
			
			
			// If login successful, display product list on index page
			model.addAttribute("plist",prodService.getAllproduct());
			
			
			return "index";
		
		}else {
			model.addAttribute("error","user not found!!");
			return "LoginForm";
		} 
	} 
	
	
	
	
	

}
