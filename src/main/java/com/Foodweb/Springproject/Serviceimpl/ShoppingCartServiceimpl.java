package com.Foodweb.Springproject.Serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Foodweb.Springproject.Model.ShoppingCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Repositry.ShoppingCartRepositry;
import com.Foodweb.Springproject.Service.ShoppingCartService;


@Service
public class ShoppingCartServiceimpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepositry shoppingCartRepo;
	

	
	
	@Override
	public void addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepo.save(shoppingCart);
	}

	

	@Override
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepo.save(shoppingCart);
		
	}

	@Override
	public ShoppingCart getShoppingCartById(int id) {
		
		return shoppingCartRepo.findById(id).get(); 
	}

	@Override
	public List<ShoppingCart> getAllShoppingCart() {
	
		return shoppingCartRepo.findAll();  
	}

	@Override
	public List<ShoppingCart> findByUser(User user) {
		// TODO Auto-generated method stub
		return shoppingCartRepo.findByUser(user); 
		
	}



	@Override
	public void deleteShoppingCartById(int id) {
		shoppingCartRepo.deleteById(id);   
		
	}

	

	

	

	

}
