package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.NonVegetarianCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Repositry.NonVegetarianCartRepositry;
import com.Foodweb.Springproject.Service.NonVegetarianCartService;

@Service
public class NonVegetarianCartServiceimpl implements NonVegetarianCartService{
     
	
	@Autowired
	private NonVegetarianCartRepositry NonVegRepo;
	
	
	@Override
	public void addNonVegetarianCart(NonVegetarianCart nonvegetarianCart) {
		
		NonVegRepo.save(nonvegetarianCart);
		
	}

	@Override
	public void deleteNonVegetarianCart(int id) {
		
		NonVegRepo.deleteById(id); 
		
	}

	@Override
	public void updateNonVegetarianCart(NonVegetarianCart nonvegetarianCart) {
		
		NonVegRepo.save(nonvegetarianCart);
		
	}

	@Override
	public NonVegetarianCart getNonVegetarianCartById(int id) {
		
		return NonVegRepo.findById(id).get();
	}

	@Override
	public List<NonVegetarianCart> getAllNonVegetarianCart() {
		// TODO Auto-generated method stub
		return NonVegRepo.findAll();
	}

	@Override
	public List<NonVegetarianCart> findByUser(User user) {
		// TODO Auto-generated method stub
		return NonVegRepo.findByUser(user);
		
	}

}
