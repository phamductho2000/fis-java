package fis.spring.jpa.service;

import java.util.List;

import fis.spring.jpa.entity.CustomerEntity;

public interface CustomerService {

	CustomerEntity save(CustomerEntity customerEntity);
	
//	CustomerEntity update(CustomerEntity customerEntity);
	
	List<CustomerEntity> findAll();
	
	CustomerEntity findById(Long id);
	
	void deleteById(Long id);
}
