package com.Foodweb.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.Fruits;

public interface FruitsRepositry extends JpaRepository<Fruits, Integer> {

}
