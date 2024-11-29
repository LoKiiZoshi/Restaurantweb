package com.Foodweb.Springproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_tbl")
public class User {
	@Id
	@GeneratedValue
  private int id;
  private String fname;
  private String lname;
  private String username;
  private String password;
  private String role;
  

}
