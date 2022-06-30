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
import com.laptopshopping.model. Admin;
import com.laptopshopping.repository.AdminRepository;

@SpringBootTest
class AdminTestCase {
	@Autowired
	private AdminRepository adminRepository;

	@Test
	@Disabled
	@Order(1)
	public void createAdmin() {
		 Admin admin = new  Admin();
		 admin.setAdminEmailId("yuvasri31599@gmail.com");
		 admin.setAdminFirstName("Yuvasri");
		 admin.setAdminPassword("Yuvasri@31");
		 admin.setAdminLastName("Sankar");
		assertNotNull(adminRepository.save(admin));
	}

	@Test
	@Disabled
	@Order(2)
	public void loginAdmin() {
		Optional< Admin> admin = adminRepository.findByAdminEmailIdAndAdminPassword("keerthana@gmail.com",
				"Keerthana@26");
		 Admin newAdmin = null;
		if (admin.isPresent()) {
			newAdmin = admin.get();
		}
		assertThat(newAdmin);
	}

	@Test
	@Disabled
	@Order(3)
	public void testReadAllAdmin() {
		List<Admin>admin = adminRepository.findAll();
		assertThat(admin).size().isGreaterThan(0);
	}

	@Test
	@Order(4)
	public void getadminById() {
		 Admin admin = adminRepository.findById(7).get();
		assertThat(admin.getAdminId()).isEqualTo(7);
	}

	@Test
	@Order(5)
	public void updateAdmin() {
		 Admin admin = adminRepository.findById(7).get();
		 admin.setAdminPassword("Yuvasri@31");
		 Admin updateAdmin = adminRepository.save(admin);
		assertThat(updateAdmin.adminPassword);
	}

	@Test
	
	@Order(6)
	public void deleteAdmin() {
		 Admin admin =adminRepository.findById(7).get();
		 adminRepository.delete(admin);
	}
}
