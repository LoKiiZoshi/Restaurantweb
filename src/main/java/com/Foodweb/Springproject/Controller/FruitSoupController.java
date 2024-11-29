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

import com.Foodweb.Springproject.Model.Fruits;
import com.Foodweb.Springproject.Service.FruitsService;


@Controller
public class FruitSoupController {
	
	@Autowired
	private FruitsService fruitsservice;
	
	
	
	@GetMapping("/Fruits")
	public String addFruitsandsoup() {
		return "AddFruitAndSoupForm";
	}
	 
	
	
	// When handling the Add Fruit and Soup Item.
	
	@PostMapping("/FruitsItem") 
	public String postFruitsItem(@ModelAttribute Fruits Fruits,@RequestParam MultipartFile image ) {
		try {
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Fruits.setImageUrl(image.getOriginalFilename());
		fruitsservice.addFruits(Fruits);
		return "AddFruitAndSoupForm";
	}
   
	
	
	// Retrieve the list of fruits and soup items in the form of a list.
	
	
	@GetMapping("/Fruitslist")
	public String getAllFruitslist(Model model) {
		model.addAttribute("Fruitlist",fruitsservice.getAllFruits());
		return "FruitsSoupListForm"; 
		
	}
	
	
	
	
	
	// second shop: view cart products shop now section.
	
	@GetMapping("/shop2")
	public String viewshop2(@ModelAttribute Fruits Fruits,Model model) {
		model.addAttribute("Fruitlist",fruitsservice.getAllFruits());
		return "SecondShop"; 
	}
	
	
	
	// Short navigation  bar to Fruit and soup item section, leading to the first shop.
	
	
	@GetMapping("/getFruits")
	public String getfruitsoup(@ModelAttribute Fruits Fruits,Model model) {
		model.addAttribute("Fruitlist",fruitsservice.getAllFruits());
		return "SecondShop";
	}
	
	
	
	
	
	
	@GetMapping("/soupandFruits/delete")
	public String deletesoupandFruits(@RequestParam int id) {
		fruitsservice.deleteFruits(id);
		return "redirect:/Fruitslist";
	}
	
	@GetMapping("/soupandFruits/edit") 
	public String edit(@RequestParam int id,Model model) {
		model.addAttribute("Fmodel", fruitsservice.getFruitsById(id));
		return "FruitsoupEditFOrm";
	}
	
	@PostMapping("/soupandFruits/update")
	public String update(@ModelAttribute Fruits Fruits) {
		fruitsservice.updateFruits(Fruits);
		return "redirect:/Fruitslist";
	}
	
	@GetMapping("/soupandfruits/View")
	public String viewsoupandfruits(@RequestParam int id,Model model) {
		model.addAttribute("Fmodel", fruitsservice.getFruitsById(id));
		return "SoupFruitsViewForm";
	}
	
	@GetMapping("/soupandfruits/Back")
	public String backFruitList() {
		return"redirect:/Fruitslist";
	}
	
	
	
}

