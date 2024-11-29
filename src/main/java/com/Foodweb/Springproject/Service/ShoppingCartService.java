package com.Foodweb.Springproject.Service;
import java.util.List;
import com.Foodweb.Springproject.Model.ShoppingCart;
import com.Foodweb.Springproject.Model.User;


public interface ShoppingCartService {
	void addShoppingCart(ShoppingCart shoppingCart);
	void deleteShoppingCartById(int id);  
	void updateShoppingCart(ShoppingCart shoppingCart);
	ShoppingCart getShoppingCartById(int id);
	List<ShoppingCart>getAllShoppingCart(); 
	
	 List<ShoppingCart> findByUser(User user);
	
	
      
} 
