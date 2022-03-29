package fis.spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.spring.jpa.entity.CustomerEntity;
import fis.spring.jpa.entity.OrderEntity;
import fis.spring.jpa.service.CustomerService;
import fis.spring.jpa.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(orderService.findAll());
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody OrderEntity o) {
		return ResponseEntity.ok(orderService.save(o));
	}
}
