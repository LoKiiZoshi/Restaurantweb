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
import com.Foodweb.Springproject.Model.NonVegetarian;
import com.Foodweb.Springproject.Service.NonVegetarianService;

@Controller
public class NonVegetarianController {
	
	@Autowired
	private NonVegetarianService nonVegetarianService;
	
	@GetMapping("/addcart")    
	public String addcart() {
		return "Addcart";  
	}
	

	
	
	// Handle Add Chicken Item request via Add Cart form with @PostMapping.

	
	@PostMapping("/Cartproduct")
	public String postaddNonVegetarian(@ModelAttribute NonVegetarian NonVegetarian,@RequestParam MultipartFile image) {
		
		try {
			Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		NonVegetarian.setImageUrl(image.getOriginalFilename());
		nonVegetarianService.addNonVegetarian(NonVegetarian);
		return "Addcart";
	}
	
	
	
	

	
	
	
	
	// First shop: view cart products shop now section.
	
	@GetMapping("/shop1")
	public String viewshop1(@ModelAttribute NonVegetarian NonVegetarian, Model model) {
		model.addAttribute("cartlist",nonVegetarianService.getAllNonVegetarian());
		return"FirstShop";
		  
	}
	
	 
	
	// Short navigation  bar to non-veg section, leading to the first shop.
	
	@GetMapping("/getchickenItem")
	public String getchickenitem(@ModelAttribute NonVegetarian NonVegetarian,Model model) {
		model.addAttribute("cartlist",nonVegetarianService.getAllNonVegetarian());
		return "FirstShop"; 
	}
	
	
	
	
	
	
	// Retrieve all cart products and display them in the cart product list.
	
	
	@GetMapping("/cartproductlist")
	public String getNonVegetarianList(Model model) {
		model.addAttribute("cartlist",nonVegetarianService.getAllNonVegetarian());
		return "cartproductlist";
		  
	}
	
	
	
	@GetMapping("/cartproduct/delete")
	public String deleteNonVegetarian(@RequestParam int id) {
		nonVegetarianService.deleteNonVegetarian(id);
		return"redirect:/cartproductlist"; 
	}
	
	@GetMapping("/cartproductedit/edit")
	public String NonVegetarianedit(@RequestParam int id, Model model) {
		model.addAttribute("cartmodel",nonVegetarianService.getNonVegetarianById(id));
		return "CartProducteditForm";
	}
	
	@PostMapping("/cartproduct/update")
	public String NonVegetarianupdate(@ModelAttribute NonVegetarian NonVegetarian ) {
		nonVegetarianService.updateNonVegetarian(NonVegetarian);
		return "redirect:/cartproductlist";
		
	} 
	
	@GetMapping("/cart/view") 
	public String viewNonVegetarian(@RequestParam int id,Model model) {
		model.addAttribute("catmodel",nonVegetarianService.getNonVegetarianById(id));
		return"cartViewForm"; 
	}
	
	@PostMapping("/cart/back")
	public String backcartlist(@ModelAttribute NonVegetarian NonVegetarian) {
		nonVegetarianService.addNonVegetarian(NonVegetarian);
		return"redirect:/cartproductlist"; 
		 
	}
	
	
	
	
	
	  
	

}
