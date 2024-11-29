package com.Foodweb.Springproject.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.Foodweb.Springproject.Model.ShoppingCart;
import com.Foodweb.Springproject.Model.User;


import com.Foodweb.Springproject.Service.ProductService;
import com.Foodweb.Springproject.Service.ShoppingCartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {
	
	
	   
	
	@Autowired
	private ProductService productservice;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@GetMapping("/AddToShoppingCart") 
	private String AddShoppingCart(@RequestParam Long id, HttpSession session,Model model ) {
		System.out.println(session.getAttribute("validuser"));
		User u = (User) session.getAttribute("validuser");
		
		ShoppingCart shoppingcart = new ShoppingCart();
		shoppingcart.setProduct(productservice.getproductById(id));
		shoppingcart.setUser(u);
		 
		
				shoppingCartService.addShoppingCart(shoppingcart);
		
		model.addAttribute("plist",productservice.getAllproduct());
		return "index";
		
	}
	 
	
	//get all shopping cart List in ShoppingCartListForm
	
	@GetMapping("/ShoppingCartlist")  
    public String showShoppingCartList(Model model) {
		 model.addAttribute("ShoppingCartList",shoppingCartService.getAllShoppingCart());
       return "ShoppingCartListForm"; 
        
    } 
	
	
	
	@GetMapping("/ShoppingCart")
	private String getCart(Model model,HttpSession session) {
		User u = (User) session.getAttribute("validuser");
		model.addAttribute("ShoppingCartList",shoppingCartService.findByUser(u));
		List<ShoppingCart> c = shoppingCartService.findByUser(u);
		model.addAttribute("size",c.size());  
		
		
		
		
		
		return"YourCart";    
		   
		}   
	 

			

	
	
	
	
//	@GetMapping("/removeShoppingCartFormYourCart")
//	private String removeShoppingCartFromYourCart(Model model, @RequestParam int id ) {
//		shoppingCartService.deleteShoppingCart(id);
//		
//		return "redirect:/ShoppingCart";
//	} 
//	
	
	
	
	
//	@GetMapping("/AddFirstShoppingCart")
//	private String AddFirstShoppingCart(@RequestParam int id,HttpSession session,Model model) {
//		User u = (User) session.getAttribute("validuser");
//		ShoppingCart ShoppingCart = new ShoppingCart();
//		ShoppingCart.setProduct(productservice.getproductById(id));
//		
//		ShoppingCart.setUser(u);
//		shoppingCartService.addShoppingCart(ShoppingCart);
//		model.addAttribute("cartlist",productservice.getAllproduct());
//		
//		return"index"; 
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/FirstShoppingcart")  
//	private String getFirstShoppingCart(Model model,HttpSession session) {
//		User u =(User) session.getAttribute("validuser");
//		model.addAttribute("cartlist",shoppingCartService.findByUser(u));
//		List<ShoppingCart> c= shoppingCartService.findByUser(u);
//		
//		model.addAttribute("size",c.size());
//		
//		
//		return"FirstShopYourCart";     
//	}
//	
	
	  
	 @GetMapping("/DeleteShoppingCartItem")
	 public String deleteShoppingCartItem(@RequestParam(required = false, defaultValue = "0") Integer id, HttpSession session, Model model) {
	        if (id != 0) {
	            shoppingCartService.deleteShoppingCartById(id);
	        } else {
	            model.addAttribute("error", "Missing required parameter 'id'.");
	        }

	        User u = (User) session.getAttribute("validuser");
	        List<ShoppingCart> cartList = shoppingCartService.findByUser(u);
	        model.addAttribute("ShoppingCartList", cartList);
	        model.addAttribute("size", cartList.size());

	        return "YourCart";
	    }
	
	
}
