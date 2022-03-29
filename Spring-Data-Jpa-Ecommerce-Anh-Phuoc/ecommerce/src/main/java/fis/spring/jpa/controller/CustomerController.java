package fis.spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.spring.jpa.entity.CustomerEntity;
import fis.spring.jpa.entity.ProductEntity;
import fis.spring.jpa.service.CustomerService;
import fis.spring.jpa.service.ProductService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody CustomerEntity c) {
		return ResponseEntity.ok(customerService.save(c));
	}
}
