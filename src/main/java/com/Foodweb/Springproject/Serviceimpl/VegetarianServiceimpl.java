package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.Vegetarian;
import com.Foodweb.Springproject.Repositry.VegetarianRepositry;
import com.Foodweb.Springproject.Service.VegetarianService;

@Service
public class VegetarianServiceimpl implements VegetarianService {
	
	
	@Autowired
	private VegetarianRepositry vegetarianRepo;

	@Override
	public void addVegetarian(Vegetarian Vegetarian) {
		vegetarianRepo.save(Vegetarian);
		
	} 

	@Override
	public void deleteVegetarian(int id) {
		vegetarianRepo.deleteById(id);
		 
	}

	@Override
	public void updateVegetarian(Vegetarian Vegetarian) {
		vegetarianRepo.save(Vegetarian);
		
	}

	@Override
	public Vegetarian getVegetarianById(int id) {
		
		return vegetarianRepo.findById(id).get();
	}

	@Override
	public List<Vegetarian> getAllVegetarian() {
		
		return vegetarianRepo.findAll();
	}
	

}
