package com.Foodweb.Springproject.Repositry;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Foodweb.Springproject.Model.ShoppingCart;
import com.Foodweb.Springproject.Model.User;

import jakarta.transaction.Transactional;


public interface ShoppingCartRepositry extends JpaRepository<ShoppingCart, Integer> { 
        List<ShoppingCart> findByUser(User user);
        void deleteByProductIdAndUserId(Long productId, int userId);
     
        
		/*
		 * @Transactional
		 * 
		 * @Modifying
		 * 
		 * @Query("Update ShoppingCart set quantity =:quantity where user.id =:id") void
		 * updateShoppingCartCartQuantity(Integer quantity,Integer id);
		 * 
		 * @Transactional
		 * 
		 * @Modifying
		 * 
		 * @Query("Update ShoppingCart set subTotal =subTotal where user.id =:id") void
		 * updateShoppingCartSubTotal(Double subTotal,Integer id);
		 * 
		 */
    	
}

