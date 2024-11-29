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

import com.Foodweb.Springproject.Model.Product;
import com.Foodweb.Springproject.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/product") 
	public String getproduct() {
		return "product";
	} 

	@GetMapping("/addProduct")
	public String addproduct() {
		return "Addproduct";
	}
	
	
	
	
	
	@GetMapping("/getindex")
	public String getindex(@ModelAttribute Product product,Model model) {
		model.addAttribute("plist", productService.getAllproduct());
		return "index"; 
	}
	
	
	
	
	// Short navigation  bar to Handles GET request to retrieve and display all products.
	
	@GetMapping("/getAllproductpage")
	public String getAllfood(@ModelAttribute Product product,Model model) {
		model.addAttribute("plist", productService.getAllproduct());
		return "AllFoodForm";
	}
	
	
	
	

	// Handles POST request for adding a product, uploads image if provided, and saves product details.
	
	
	@PostMapping("/Product")
	public String postproduct(@ModelAttribute Product product, @RequestParam MultipartFile image) {

		if (!image.isEmpty()) {

			try {
				Files.copy(image.getInputStream(),
						Path.of("src/main/resources/static/image/" + image.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		product.setImageUrl(image.getOriginalFilename());
		productService.addproduct(product);
		
		return "Addproduct";
	}
	
	
	// Handles GET request to retrieve and display the product list.

	@GetMapping("/productList")
	public String getproductList(Model model) {
		model.addAttribute("plist", productService.getAllproduct());
		return "ProductListForm";
	}
	

	@GetMapping("/product/delete")
	public String deleteproduct(@RequestParam Long id) {
		productService.deleteproduct(id);
		return "redirect:/productList"; 
	}

	@GetMapping("/pro/edit")
	public String edit(@RequestParam Long id, Model model) {
		model.addAttribute("pmodel", productService.getproductById(id));
		return "ProductEditForm";
	}

	@PostMapping("/pro/update")
	public String update(@ModelAttribute Product product) {
		productService.updateproduct(product);
		return "redirect:/productList";
	}

	@GetMapping("/pro/view")
	public String viewproduct(@RequestParam Long id, Model model) {

		model.addAttribute("pmodel", productService.getproductById(id));
		return "productViewForm";
	}

	@PostMapping("/pro/Back")
	public String backprolist(@ModelAttribute Product product) {
		productService.addproduct(product);
		return "redirect:/productList";

	}

}
