package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.FruitsCart;
import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Repositry.FruitsCartRepositry;
import com.Foodweb.Springproject.Service.FruitsCartService;

@Service
public class FruitCartServiceimpl implements FruitsCartService {
  
	@Autowired
    private FruitsCartRepositry fruitscartrepo;
    
    
	@Override
	public void addFruitsCart(FruitsCart fruitscart) {
		fruitscartrepo.save(fruitscart);
		
	}

	@Override
	public void deleteFruitsCart(int id) {
		fruitscartrepo.deleteById(id); 
		
	}

	@Override
	public void updateFruitsCart(FruitsCart fruitscart) {
		fruitscartrepo.save(fruitscart);
		
	}

	@Override
	public FruitsCart getFruitsCartById(int id) {
		// TODO Auto-generated method stub
		return fruitscartrepo.findById(id).get(); 
	}

	@Override
	public List<FruitsCart> getAllFruitsCart() {
		// TODO Auto-generated method stub
		return fruitscartrepo.findAll(); 
	}

	@Override
	public List<FruitsCart> findByUser(User user) {
		// TODO Auto-generated method stub
		return fruitscartrepo.findByUser(user); 
	}
	

}
