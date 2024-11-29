package com.Foodweb.Springproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="category_tbl")
public class Category {
	@Id
	@GeneratedValue
	private int id;
	private String category;
	private String search;
	

}
