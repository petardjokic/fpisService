package fon.is.fpis.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fon.is.fpis.domain.Product;

class ProductRepositoryTest extends BasicSpringTest{
	
	@Autowired
	ProductRepository productRepo;

	//@Test
	void test() {
		Product product1 = Product.builder().name("Productooo").build();
		Product product2 = productRepo.save(product1);
		assertEquals(product1.getId(), product2.getId());
		assertEquals(product1.getName(), product2.getName());
	}

}
