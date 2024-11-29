package com.Foodweb.Springproject.Controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Foodweb.Springproject.Model.FruitsCart;
import com.Foodweb.Springproject.Model.NonVegetarianCart;
import com.Foodweb.Springproject.Model.ShoppingCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Model.VegetarianCart;
import com.Foodweb.Springproject.Service.FruitsCartService;
import com.Foodweb.Springproject.Service.NonVegetarianCartService;

import com.Foodweb.Springproject.Service.ShoppingCartService;
import com.Foodweb.Springproject.Service.VegetarianCartService;

import jakarta.servlet.http.HttpSession;




@Controller
public class CheckoutController {
	
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private NonVegetarianCartService nonvegcartservice; 
	
	
	@Autowired
	private FruitsCartService fruitscartservice; 
	
	
	
	@Autowired
	private VegetarianCartService vegetariancartservice;
	
	
	
	
	//All product check out index form 
	
	@GetMapping("/Checkout")
    public String checkout(@RequestParam("quantity")int quantity,Model model, HttpSession session) {
       User u = (User) session.getAttribute("validuser");
       System.out.println(u.getId());
       System.out.println(shoppingCartService.findByUser(u));
       
       model.addAttribute("ShoppingCartList",shoppingCartService.findByUser(u));
       List<ShoppingCart>cs = shoppingCartService.findByUser(u);
       model.addAttribute("size",cs.size());
       model.addAttribute("quantity",quantity);   // Add quantity to the model
       
   
         
		  
        return "checkout";  
    }
	 
	 
	 
	 //Chicken product First shop
	 
	 @GetMapping("/nonvegCheckout")  
	 public String nonvegCheckout(@RequestParam("quantity")int quantity,Model model,HttpSession session) {
		 User u = (User) session.getAttribute("validuser");
		 
		 model.addAttribute("cartlist",nonvegcartservice.findByUser(u));
		 List<NonVegetarianCart> n = nonvegcartservice.findByUser(u);
		 model.addAttribute("size",n.size());
		 model.addAttribute("quantity",quantity);
		 
		 return "FirstShopCheckout";  
		 
	 }
	 
	 
	 
	//Fruits product second shop
	 
	 @GetMapping("/FruitsCheckout") 
	 public String Fruits(@RequestParam("quantity")int quantity,Model model,HttpSession session) {
		 User u= (User) session.getAttribute("validuser");
		 
		 model.addAttribute("Fruitlist",fruitscartservice.findByUser(u));
		 List<FruitsCart> f= fruitscartservice.findByUser(u);
		 model.addAttribute("size",f.size());
		 model.addAttribute("quantity",quantity);
		 
		 return "SecondSHopCheckout"; 
		 
		 
		
	 }
	 
  //vegetarian third shop
	 @GetMapping("/vegetariancartCheckout")
	 public String vegetariancartcheckout(@RequestParam("quantity")int quantity,Model model,HttpSession session) {
		 User u = (User) session.getAttribute("validuser");
		 
		 model.addAttribute("vegetarianfoodlist",vegetariancartservice.findByUser(u));
		 List<VegetarianCart> v = vegetariancartservice.findByUser(u);
		 model.addAttribute("size",v.size());
		 model.addAttribute("quantity",quantity);
		 
		 return "ThirdShopCheckout";    
		 
		 
	 }
	

}


			

