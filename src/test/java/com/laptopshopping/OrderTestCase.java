package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.laptopshopping.model.Order;
import com.laptopshopping.model.Product;
import com.laptopshopping.repository.OrderRepository;
import com.laptopshopping.repository.ProductRepository;



class OrderTestCase {

	@Autowired
	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	@Test
	//@Disabled
	public void addProduct(){
		Order order = new Order();
		order.setCustomerId(101);
		order.setProductId(201);
		Product product = productRepository.findById(201).get();
		order.setProductPrice(product.getProductPrice());
		order.setQuantity(3);
		order.setTotalPrice(order.getQuantity() * order.getProductPrice());
		order.setOrderedDate(java.time.LocalDate.now());
		order.setDeliveryStatus("payment pending");
		assertNotNull(orderRepository.save(order));
	}
	
}
