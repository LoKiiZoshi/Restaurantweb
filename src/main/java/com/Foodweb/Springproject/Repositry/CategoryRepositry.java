package com.Foodweb.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.Category;

public interface CategoryRepositry extends JpaRepository<Category, Integer>{
	

}
