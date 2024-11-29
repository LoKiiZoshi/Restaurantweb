package com.Foodweb.Springproject.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Foodweb.Springproject.Model.User;
import com.Foodweb.Springproject.Model.VegetarianCart;

public interface VegetarianCartRepositry extends JpaRepository<VegetarianCart, Integer> {
          List<VegetarianCart> findByUser(User user);
}
