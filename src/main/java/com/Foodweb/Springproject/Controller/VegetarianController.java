package com.Foodweb.Springproject.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.Foodweb.Springproject.Model.Vegetarian;
import com.Foodweb.Springproject.Service.VegetarianService;

@Controller
public class VegetarianController {
	
	@Autowired
	private VegetarianService vegetarianService;
	
	
	@GetMapping("/vegetarian")
	public String addvegetarianfood() {
		return"AddVegetarianForm";
		
	}

	
	
	
	// Handles POST request for adding vegetarian food, uploads image, and saves food details.

	
	@PostMapping("/vegetarianfood")
	public String postvegetarianfood(@ModelAttribute Vegetarian Vegetarian,@RequestParam MultipartFile image) {
		 
		try {
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Vegetarian.setImageUrl(image.getOriginalFilename());
		vegetarianService.addVegetarian(Vegetarian);
		return "AddVegetarianForm";
		
	}
	
	
	// Handles GET request to retrieve and display all vegetarian food items list.
	
	@GetMapping("/vegetarianfoodlist")
	public String getAllvegetarianlist(Model model) {
		model.addAttribute("vegetarianfoodlist",vegetarianService.getAllVegetarian());
		return "VegetarianlistForm"; 
	}
	
	
	

	
	// Handles GET request to view the third shop, displaying all vegetarian food items.
	
	@GetMapping("/shop3")
	public String viewshop3(@ModelAttribute Vegetarian Vegetarian,Model model) {
		model.addAttribute("vegetarianfoodlist",vegetarianService.getAllVegetarian());
	    return  "Thredshop"; 	 
	}
	
	
	
	//Short navigation  bar to This method handles GET requests to getvegetarianItem.
	
	@GetMapping("/getvegetarianItem")
	public String getvegetarian(@ModelAttribute Vegetarian Vegetarian,Model model) {
		model.addAttribute("vegetarianfoodlist",vegetarianService.getAllVegetarian());
		return "Thredshop";
	}
	
	
	
	
	
	@GetMapping("/vegetarianItem/Delete")
	public String deletevegetarianItem(@RequestParam int id) {
		vegetarianService.deleteVegetarian(id);
		return "redirect:/vegetarianfoodlist";
		
	}
	
	
	@GetMapping("/vegetarian/edit") 
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("Vmodel",vegetarianService.getVegetarianById(id));
		return "VegetarianeditForm";
	}
	
	@PostMapping("/vegetarian/update")
	public String update(@ModelAttribute Vegetarian vegetarian) {
		vegetarianService.updateVegetarian(vegetarian);
		return"redirect:/vegetarianfoodlist";
	}
	 
	
	@GetMapping("/vegetarian/view")
	public String viewvegetarian(@RequestParam int id, Model model) {
		model.addAttribute("Vmodel",vegetarianService.getVegetarianById(id));
		return "VegetarianViewForm";
	}
	
	
	@GetMapping("/vegetarian/back")
	public String backvegetarianlist() {
		
		return "redirect:/vegetarianfoodlist";
	}
	
	}
