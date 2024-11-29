package com.Foodweb.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Foodweb.Springproject.Model.Category;
import com.Foodweb.Springproject.Service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryservice;

	@GetMapping("/category")
	public String getcategory(){
		return"CategoryForm";
	} 
	
	@PostMapping("/serch")
	public String postserch(@ModelAttribute Category Category ) {
		categoryservice.addcategory(Category);
		return "CategoryForm";	
	}
	
	@GetMapping("/categoryList")
	public String getcategoryList(Model model) {
		model.addAttribute("catlist", categoryservice.getAllCategory());
		return"categorylistForm";
	}
	@GetMapping("/category/delete")
	public String deletecategory(@RequestParam  int id) {
		categoryservice.deletecategory(id);
		return"redirect:/categoryList";
	}
	
	@GetMapping("/category/edit")
	public String edit(@RequestParam int id,Model model) {
		model.addAttribute("catmodel",categoryservice.getCategoryById(id));
		return"categoryeditForm";
	}
	
	@PostMapping("/category/update")
	public String upadate(@ModelAttribute Category category) {
		categoryservice.updatecategory(category);
		return"redirect:/categoryList";
		 
	}
	
	@GetMapping("/category/view")
	public String viewcategory(@RequestParam int id,Model model) {
		model.addAttribute("catmodel",categoryservice.getCategoryById(id));
		return"categoryViewForm";
	}
	
	@PostMapping("/category/back")
	public String backcategorylist(@ModelAttribute Category category) {
		categoryservice.addcategory(category);
		return"redirect:/categoryList"; 
	}
	
	
	 
	
	
}

