package com.Foodweb.Springproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "NonVegetarianCart")
public class NonVegetarianCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="NonVegetarian_id")
	private NonVegetarian NonVegetarian;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

} 

