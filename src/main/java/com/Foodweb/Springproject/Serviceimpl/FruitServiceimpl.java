package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.Fruits;
import com.Foodweb.Springproject.Repositry.FruitsRepositry;
import com.Foodweb.Springproject.Service.FruitsService;

@Service
public class FruitServiceimpl implements FruitsService{
	
	@Autowired
	private FruitsRepositry FruitsRepo;
	

	@Override
	public void addFruits(Fruits Fruits) {
		FruitsRepo.save(Fruits);
		
	}

	@Override
	public void deleteFruits(int id) {
		FruitsRepo.deleteById(id);
		
	}

	@Override
	public void updateFruits(Fruits Fruits) {
		FruitsRepo.save(Fruits);
		
	}

	@Override
	public Fruits getFruitsById(int id) {
				return FruitsRepo.findById(id).get();
	}

	@Override
	public List<Fruits> getAllFruits() {
		
		return FruitsRepo.findAll();
		
	}

}
