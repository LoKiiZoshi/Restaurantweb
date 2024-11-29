package com.Foodweb.Springproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Model.VegetarianCart;
import com.Foodweb.Springproject.Service.VegetarianCartService;
import com.Foodweb.Springproject.Service.VegetarianService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VegetarianCartController {
	
	
	@Autowired
	private VegetarianService vegetarianservice;
	
	@Autowired
	private VegetarianCartService vegetariancartservice;
	
	
	@GetMapping("/AddToVegetarianCart")
	private String AddVegetarianCart(@RequestParam int id,HttpSession session,Model model) {
		
		User u = (User) session.getAttribute("validuser");
		VegetarianCart vegetariancart = new VegetarianCart();
		vegetariancart.setVegetarian(vegetarianservice.getVegetarianById(id));
		vegetariancart.setUser(u);
		
		vegetariancartservice.addVegetarianCart(vegetariancart);
		
		model.addAttribute("vegetarianfoodlist",vegetarianservice.getAllVegetarian());
		return "Thredshop"; 
		
	}
	
	@GetMapping("/vegetarianCart") 
	private String getVegetarianCart(Model model,HttpSession session) {
		
		User u = (User) session.getAttribute("validuser");
		model.addAttribute("vegetarianfoodlist",vegetariancartservice.findByUser(u));
		List<VegetarianCart> v = vegetariancartservice.findByUser(u);
		model.addAttribute("size",v.size()); 
		
		return "ThirdshopYourCart";    
	}

}
