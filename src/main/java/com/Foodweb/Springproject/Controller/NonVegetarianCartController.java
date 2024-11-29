package com.Foodweb.Springproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Foodweb.Springproject.Model.NonVegetarianCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Service.NonVegetarianCartService;
import com.Foodweb.Springproject.Service.NonVegetarianService;

import jakarta.servlet.http.HttpSession;


@Controller
public class NonVegetarianCartController {
	
	
	
	@Autowired
	private NonVegetarianService Nonvegetarianservice;
	
	@Autowired
	private NonVegetarianCartService nonVegetarianCartService;
	
	
	@GetMapping("/AddToCartNonVegetarian")    
	private String AddNonVegetarianCart(@RequestParam int id, HttpSession session,Model model) {
		
		User u = (User) session.getAttribute("validuser");
		NonVegetarianCart nonvegcart = new NonVegetarianCart();
		nonvegcart.setNonVegetarian(Nonvegetarianservice.getNonVegetarianById(id));
		nonvegcart.setUser(u);
		
	    nonVegetarianCartService.addNonVegetarianCart(nonvegcart);
	    
	    model.addAttribute("cartlist",Nonvegetarianservice.getAllNonVegetarian());
	    return "FirstShop";   
	}
	
	
	
	
	@GetMapping("/shoppingNonvegCart")  
	private String getnonvegCart(Model model,HttpSession session) {
		User u = (User) session.getAttribute("validuser");
		model.addAttribute("cartlist",nonVegetarianCartService.findByUser(u));
		List<NonVegetarianCart> n = nonVegetarianCartService.findByUser(u);
		model.addAttribute("size",n.size()); 
		return "FirstShopYourCart";
	}
	
	
	
	

}
