package fis.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.spring.jpa.entity.CustomerEntity;
import fis.spring.jpa.repo.CustomerRepo;
import fis.spring.jpa.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public CustomerEntity save(CustomerEntity customerEntity) {
		if (customerEntity.getId() != null) {
			CustomerEntity updateC = findById(customerEntity.getId());
			updateC.setFullName(customerEntity.getFullName());
			updateC.setBirthDay(customerEntity.getBirthDay());
			updateC.setAddress(customerEntity.getAddress());
			return customerRepo.save(updateC);
		} else {
			return customerRepo.save(customerEntity);
		}
	}

	@Override
	public List<CustomerEntity> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public CustomerEntity findById(Long id) {
		Optional<CustomerEntity> c = customerRepo.findById(id);
		return c.isPresent() ? c.get() : null;
	}

	@Override
	public void deleteById(Long id) {
		customerRepo.deleteById(id);
	}

}
