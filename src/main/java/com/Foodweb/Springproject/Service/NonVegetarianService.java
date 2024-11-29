package com.Foodweb.Springproject.Service;
import java.util.List;
import com.Foodweb.Springproject.Model.NonVegetarian;

public interface NonVegetarianService {
	void addNonVegetarian(NonVegetarian NonVegetariant);
	void deleteNonVegetarian(int id);
	void updateNonVegetarian(NonVegetarian NonVegetarian);
	NonVegetarian getNonVegetarianById(int id);
	
	List<NonVegetarian>getAllNonVegetarian();

}
