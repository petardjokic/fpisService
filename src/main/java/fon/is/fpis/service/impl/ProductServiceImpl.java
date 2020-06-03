package fon.is.fpis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fon.is.fpis.dao.ProductRepository;
import fon.is.fpis.domain.Product;
import fon.is.fpis.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
		this.productRepo = productRepo;
//		productRepo.save(Product.builder().name("Product1").build());
//		productRepo.save(Product.builder().name("Product2").build());
//		productRepo.save(Product.builder().name("Product3").build());
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getById(Long id) {
		return productRepo.findById(id).get();
	}

}
