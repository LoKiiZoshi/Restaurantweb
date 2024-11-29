package com.Foodweb.Springproject.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.NonVegetarianCart;
import com.Foodweb.Springproject.Model.User;

public interface NonVegetarianCartRepositry extends JpaRepository<NonVegetarianCart, Integer>{
	List<NonVegetarianCart>findByUser(User user); 

}
