package com.Foodweb.Springproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Foodweb.Springproject.Model.FruitsCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Service.FruitsCartService;
import com.Foodweb.Springproject.Service.FruitsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FruitsCartController { 
	
	@Autowired
	private FruitsService fruitsservice;
	
	@Autowired
	private FruitsCartService fruitscartservice;
	
	@GetMapping("/AddTOCartFruits")
	private String AddFruitsCart(@RequestParam int id,HttpSession session,Model model) {
		User u = (User) session.getAttribute("validuser");
		FruitsCart fruitscart = new FruitsCart();
		fruitscart.setFruits(fruitsservice.getFruitsById(id));
		fruitscart.setUser(u);
		
		fruitscartservice.addFruitsCart(fruitscart);
		
		model.addAttribute("Fruitlist",fruitsservice.getAllFruits());
		return "SecondShop";    
	}  
	
	
	@GetMapping("/ShoppingFruitsCart") 
	private String getFruitsCart(Model model,HttpSession session) {
		User u = (User) session.getAttribute("validuser");
		model.addAttribute("Fruitlist",fruitscartservice.findByUser(u));
		List<FruitsCart> f = fruitscartservice.findByUser(u); 
		model.addAttribute("size",f.size());
		return "SecondShopYourCart";    
	}

}
