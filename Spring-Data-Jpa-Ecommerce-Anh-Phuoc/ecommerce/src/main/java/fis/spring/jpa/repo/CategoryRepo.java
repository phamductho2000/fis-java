package fis.spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fis.spring.jpa.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {

}
