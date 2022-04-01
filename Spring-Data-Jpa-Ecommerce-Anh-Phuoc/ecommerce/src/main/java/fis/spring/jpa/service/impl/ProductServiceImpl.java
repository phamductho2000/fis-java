package fis.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.spring.jpa.entity.ProductEntity;
import fis.spring.jpa.exception.NotFoundException;
import fis.spring.jpa.repo.ProductRepo;
import fis.spring.jpa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	Logger log;

	@Override
	public ProductEntity save(ProductEntity productEntity) {
		if (productEntity.getId() != null) {
			ProductEntity updateP = findById(productEntity.getId());
			updateP.setName(productEntity.getName());
			updateP.setPrice(productEntity.getPrice());
			updateP.setDes(productEntity.getDes());
			return productRepo.save(updateP);
		} else {
			return productRepo.save(productEntity);
		}
	}

	@Override
	public List<ProductEntity> findAll() {
		return productRepo.findAll();
	}

	@Override
	public ProductEntity findById(Long id) {
		Optional<ProductEntity> p = productRepo.findById(id);
		if(!p.isPresent()) {
			throw new NotFoundException("Not found user with ID = " + id);
		}
		return p.get();
	}

	@Override
	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}

}
