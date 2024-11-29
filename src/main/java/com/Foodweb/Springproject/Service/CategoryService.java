package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.Category;

public interface CategoryService {
	void addcategory(Category Category);
	void deletecategory(int id);
	void updatecategory(Category Category);
	Category getCategoryById(int id);
	List<Category>getAllCategory();
	

}
