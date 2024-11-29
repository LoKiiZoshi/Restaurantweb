package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.Fruits;

public interface FruitsService {
	void addFruits(Fruits Fruits);
	void deleteFruits(int id);
	void updateFruits(Fruits Fruits);
	Fruits getFruitsById(int id);
	List<Fruits>getAllFruits();

}
