package com.Foodweb.Springproject.Service;

import java.util.List;

import com.Foodweb.Springproject.Model.DeliveryAddress;

public interface DeliveryAddressService {
	
	void addDelivery(DeliveryAddress address);
	void deleteDeliveryAddressById(int id);
	void updateDeliveryAddress(DeliveryAddress address);
	DeliveryAddress getDeliveryAddressById(int id);
	List<DeliveryAddress>getAllDeliveryAddress();
	int getRandomQuantity();
	
}
  