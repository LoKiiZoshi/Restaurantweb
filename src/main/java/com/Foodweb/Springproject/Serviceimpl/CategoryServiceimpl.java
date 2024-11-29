package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Foodweb.Springproject.Model.Category;
import com.Foodweb.Springproject.Repositry.CategoryRepositry;
import com.Foodweb.Springproject.Service.CategoryService;


@Service
public class CategoryServiceimpl implements CategoryService {

	
	@Autowired
	private CategoryRepositry categoryripo;
	
	@Override
	public void addcategory(Category Category) {
		categoryripo.save(Category);
		
	}

	@Override
	public void deletecategory(int id) {
		categoryripo.deleteById(id);
		
	}

	@Override
	public void updatecategory(Category Category) {
		categoryripo.save(Category);
		
	}

	@Override
	public Category getCategoryById(int id) {
		
		return categoryripo.findById(id).get();
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryripo.findAll();
	}

}
