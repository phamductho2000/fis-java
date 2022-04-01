package fis.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.spring.jpa.entity.CategoryEntity;
import fis.spring.jpa.exception.NotFoundException;
import fis.spring.jpa.repo.CategoryRepo;
import fis.spring.jpa.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public CategoryEntity save(CategoryEntity categoryEntity) {
		if (categoryEntity.getId() != null) {
			CategoryEntity updateC = findById(categoryEntity.getId());
			updateC.setName(categoryEntity.getName());
			updateC.setProducts(categoryEntity.getProducts());
			return categoryRepo.save(updateC);
		} else {
			return categoryRepo.save(categoryEntity);
		}
	}

	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public CategoryEntity findById(Long id) {
		Optional<CategoryEntity> c = categoryRepo.findById(id);
		if(!c.isPresent()) {
			throw new NotFoundException("Not found category with ID = " + id);
		}
		return c.get();
	}

	@Override
	public void deleteById(Long id) {
		categoryRepo.deleteById(id);
	}

}
