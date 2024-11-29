package com.Foodweb.Springproject.Serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Foodweb.Springproject.Model.NonVegetarian;
import com.Foodweb.Springproject.Repositry.NonVegetarianRepositry;
import com.Foodweb.Springproject.Service.NonVegetarianService;


@Service
public class NonVegetarianServiceimpl implements NonVegetarianService {
	
	@Autowired
	private NonVegetarianRepositry NonVegetarianRepo;

	@Override
	public void addNonVegetarian(NonVegetarian NonVegetarian) {
		NonVegetarianRepo.save(NonVegetarian);
		
	}

	@Override
	public void deleteNonVegetarian(int id) {
		NonVegetarianRepo.deleteById(id); 
		
	}

	@Override
	public void updateNonVegetarian(NonVegetarian NonVegetarian) {
		NonVegetarianRepo.save(NonVegetarian);
	}

	@Override
	public NonVegetarian getNonVegetarianById(int id) {
		
		return NonVegetarianRepo.findById(id).get();
	}

	@Override
	public List<NonVegetarian> getAllNonVegetarian() {
		
		return NonVegetarianRepo.findAll();
	}

	

}
