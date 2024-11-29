package com.Foodweb.Springproject.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.FruitsCart;
import com.Foodweb.Springproject.Model.User;

public interface FruitsCartRepositry extends JpaRepository<FruitsCart, Integer>{
   List<FruitsCart>findByUser(User user); 
	
}
