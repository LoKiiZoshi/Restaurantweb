package com.Foodweb.Springproject.Serviceimpl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Foodweb.Springproject.Model.DeliveryAddress;
import com.Foodweb.Springproject.Repositry.DeliveryAddressRepositry;
import com.Foodweb.Springproject.Service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceimpl implements DeliveryAddressService {
	
	@Autowired DeliveryAddressRepositry   DeliveryRipo;

	@Override
	public void addDelivery(DeliveryAddress address) {
		DeliveryRipo.save(address);
		
	}

	@Override
	public void deleteDeliveryAddressById(int id) {
		DeliveryRipo.deleteById(id); 
	}

	@Override
	public void updateDeliveryAddress(DeliveryAddress address) {
		DeliveryRipo.save(address);
		
	}

	@Override
	public DeliveryAddress getDeliveryAddressById(int id) {
		
		return DeliveryRipo.findById(id).get();
	}

	@Override
	public List<DeliveryAddress> getAllDeliveryAddress() {
		
		return DeliveryRipo.findAll();  
	}

	@Override
	public int getRandomQuantity() {
		 Random random = new Random();
	     return random.nextInt(100) + 1; // Random quantity between 1 and 100
	}
	
	
  
}
