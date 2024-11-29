package com.Foodweb.Springproject.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Foodweb.Springproject.Model.DeliveryAddress;
import com.Foodweb.Springproject.Model.Product;
import com.Foodweb.Springproject.Model.ShoppingCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Service.DeliveryAddressService;
import com.Foodweb.Springproject.Service.ProductService;
import com.Foodweb.Springproject.Service.ShoppingCartService;


import jakarta.servlet.http.HttpSession;   

@Controller   
public class DeliveryAddressController {  

	@Autowired
	private ProductService ps;
	
	@Autowired
	private ShoppingCartService shoppingcartservice;  
	
	@Autowired
	private DeliveryAddressService   DeliveryAddressservice;
	@Autowired 
	ShoppingCartService scs;
	
	

	@PostMapping("/placeorder") 
	public String getPlaceOrder(@ModelAttribute DeliveryAddress deliveryAddress, HttpSession session) {
		User user = (User) session.getAttribute("validuser");

		if (user == null) {
			return "redirect:/login"; // Redirect to login if user is not logged in
		}
		deliveryAddress.setUser(user);

		List<ShoppingCart> shoppingCart= scs.findByUser(user);
		List<Product> productList= new ArrayList<>();
		for(ShoppingCart c: shoppingCart) {
			productList.add(c.getProduct());
		}
		
		

		deliveryAddress.setProductList(productList);

		DeliveryAddressservice.addDelivery(deliveryAddress);

  
		return "checkout";             
	}
	
	 
	
	
	

	//for admin page AllItemDeliveryAddressDetails -------** 
	@GetMapping("/AllItemDeliveryAddressDetail")     
	private String AddShoppingCart(@RequestParam int id,Model model ) {
		model.addAttribute("deliveryAddress",DeliveryAddressservice.getDeliveryAddressById(id));
		System.out.println(DeliveryAddressservice.getAllDeliveryAddress());      
		return "Order";   
		   
		
	} 
	
	
	
	@GetMapping("/DeliveryAddressList")       
	public String placeorderlist(Model model) {  
		model.addAttribute("DList",DeliveryAddressservice.getAllDeliveryAddress());
		return "OrderDetails";                 
	}  
	
    
	 

}
