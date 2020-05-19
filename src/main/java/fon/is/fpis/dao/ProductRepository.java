package fon.is.fpis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fon.is.fpis.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
