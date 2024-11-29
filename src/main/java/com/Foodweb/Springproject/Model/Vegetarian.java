package com.Foodweb.Springproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="vegetarianFood_Item")
public class Vegetarian {
	@Id
	@GeneratedValue
	private int id;
	private String vegetarianItem_Name;
	private Double price; 
	private int quantity; 
	private String imageUrl;

}
