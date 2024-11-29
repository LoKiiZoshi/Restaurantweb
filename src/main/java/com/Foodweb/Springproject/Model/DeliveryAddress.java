package com.Foodweb.Springproject.Model;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Place_Oreder_Details")

public class DeliveryAddress {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String address;
	    private String city;
	    private String country;  
	    private String zipCode;
	    private String note;
	    private String telephone;
	    
  
	    @OneToOne 
	    @JoinColumn(name = "User_id")
	    private User user;  
	    
	    @ManyToMany
	    private List<Product> productList;    
	      
	    
	
	   
}
