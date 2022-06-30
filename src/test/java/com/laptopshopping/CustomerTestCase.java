package com.laptopshopping;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import com.laptopshopping.model.Customer;
import com.laptopshopping.repository.CustomerRepository;

@SpringBootTest
class CustomerTestCase {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	@Disabled
	@Order(1)
	public void createCustomer() {
		Customer customer = new Customer();
		customer.setCustomerEmailId("keerthikshah@gmail.com");
		customer.setCustomerFirstName("Keerthikshah");
		customer.setCustomerPassword("Keerthi@28");
		customer.setCustomerLastName("Sampath");
		assertNotNull(customerRepository.save(customer));
	}

	@Test
	//@Disabled
	@Order(2)
	public void loginCustomer() {
		Optional<Customer> customer = customerRepository.findByCustomerEmailIdAndCustomerPassword("keerthikshah@gmail.com",
				"Keerthi@28");
		Customer newCustomer = null;
		if (customer.isPresent()) {
			newCustomer = customer.get();
		}
		assertThat(newCustomer);
	}

	@Test
	//@Disabled
	@Order(3)
	public void testReadAllCustomer() {
		List<Customer> customer = customerRepository.findAll();
		assertThat(customer).size().isGreaterThan(0);
	}

	@Test
	//@Disabled
	@Order(4)
	public void getCustomerById() {
		Customer customer = customerRepository.findById(101).get();
		assertThat(customer.getCustomerId()).isEqualTo(101);
	}

	@Test
	//@Disabled
	@Order(5)
	public void updateCustomer() {
		Customer customer = customerRepository.findById(101).get();
		customer.setCustomerPassword("Gomathi@111");
		Customer updateCustomer = customerRepository.save(customer);
		assertThat(updateCustomer.customerPassword);
	}

	@Test
	@Disabled
	@Order(6)
	public void deleteCustomer() {
		Customer customer = customerRepository.findById(101).get();
		customerRepository.delete(customer);
	}
}
