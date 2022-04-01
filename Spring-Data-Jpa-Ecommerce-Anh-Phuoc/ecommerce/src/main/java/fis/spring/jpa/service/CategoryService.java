package fis.spring.jpa.service;

import java.util.List;

import fis.spring.jpa.entity.CategoryEntity;


public interface CategoryService {

	CategoryEntity save(CategoryEntity categoryEntity);

//	OrderEntity update(OrderEntity orderEntity);

	List<CategoryEntity> findAll();

	CategoryEntity findById(Long id);

	void deleteById(Long id);
}
