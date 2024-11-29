package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.Vegetarian;

public interface VegetarianService {
	void addVegetarian(Vegetarian Vegetarian);
	void deleteVegetarian(int id);
	void updateVegetarian(Vegetarian Vegetarian);
	Vegetarian getVegetarianById(int id);
	List<Vegetarian>getAllVegetarian();
	
}
