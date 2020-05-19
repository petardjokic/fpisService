package fon.is.fpis.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fon.is.fpis.domain.Product;
import fon.is.fpis.domain.StorageFinalProductWarrant;
import fon.is.fpis.domain.StorageWarantItem;

class StorageFinalProductWarrantRepositoryTest extends BasicSpringTest {

	@Autowired
	StorageFinalProductWarrantRepository warrantRepo;
	
	@Autowired
	ProductRepository productRepo;

	@Test
	void test() {
		Product product1 = Product.builder().name("Productooo").build();
		Product product2 = Product.builder().name("elstra").build();
		productRepo.save(product1);
		productRepo.save(product2);
		StorageFinalProductWarrant warrant = StorageFinalProductWarrant.builder().date(LocalDate.now()).build();
		List<StorageWarantItem> items = Arrays.asList(
				StorageWarantItem.builder().amount(3).note("skap").product(product1).build(),
				StorageWarantItem.builder().amount(5).note("paks").product(product2).build()
				);
		warrant.setItems(items);
		warrantRepo.save(warrant);
		
	}

}
