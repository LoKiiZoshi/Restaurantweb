package com.Foodweb.Springproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Fruitshoup_Item")
public class Fruits {
	@Id
	@GeneratedValue
	private int id;
	private String FruitShoup_Nmae;
	private Double price;
	private int quantity; 
	private String imageUrl;
	

}
