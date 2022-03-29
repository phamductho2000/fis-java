package fis.spring.jpa.service;

import java.util.List;

import fis.spring.jpa.entity.ProductEntity;

public interface ProductService {
	ProductEntity save(ProductEntity productEntity);
	
//	ProductEntity update(ProductEntity productEntity);
	
	List<ProductEntity> findAll();
	
	ProductEntity findById(Long id);
	
	void deleteById(Long id);
}
