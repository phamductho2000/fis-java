package fis.spring.jpa.service;

import java.util.List;

import fis.spring.jpa.entity.OrderEntity;

public interface OrderService {

	OrderEntity save(OrderEntity orderEntity);

//	OrderEntity update(OrderEntity orderEntity);

	List<OrderEntity> findAll();

	OrderEntity findById(Long id);

	void deleteById(Long id);
}
