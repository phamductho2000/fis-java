package fis.spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fis.spring.jpa.entity.CategoryEntity;
import fis.spring.jpa.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody CategoryEntity c) {
		return ResponseEntity.ok(categoryService.save(c));
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(categoryService.findById(id));
	}
}
