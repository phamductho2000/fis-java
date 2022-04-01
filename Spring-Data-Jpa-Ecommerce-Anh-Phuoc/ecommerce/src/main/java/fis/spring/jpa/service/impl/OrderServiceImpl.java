package fis.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.spring.jpa.entity.OrderDetailEntity;
import fis.spring.jpa.entity.OrderEntity;
import fis.spring.jpa.entity.ProductEntity;
import fis.spring.jpa.exception.NotFoundException;
import fis.spring.jpa.repo.OrderDetailRepo;
import fis.spring.jpa.repo.OrderRepo;
import fis.spring.jpa.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;

	@Override
	public OrderEntity save(OrderEntity orderEntity) {
		if (orderEntity.getId() != null) {
			OrderEntity updateO = findById(orderEntity.getId());
			updateO.setStatus(orderEntity.getStatus());
			updateO.setTotal(orderEntity.getTotal());
			updateO.setOrderDetail(orderEntity.getOrderDetail());
			updateO.setCustomer(orderEntity.getCustomer());

			List<OrderDetailEntity> orderDetailEntities = orderEntity.getOrderDetail();
			for (OrderDetailEntity oDetail : orderDetailEntities) {
				oDetail.setOrder(updateO);
				orderDetailRepo.save(oDetail);
			}
			return orderRepo.save(updateO);
		} else {
			OrderEntity savedO = orderRepo.save(orderEntity);
			List<OrderDetailEntity> orderDetailEntities = orderEntity.getOrderDetail();
			for (OrderDetailEntity oDetail : orderDetailEntities) {
				oDetail.setOrder(savedO);
				orderDetailRepo.save(oDetail);
			}
			return savedO;
		}
	}

	@Override
	public List<OrderEntity> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public OrderEntity findById(Long id) {
		Optional<OrderEntity> o = orderRepo.findById(id);
		if(!o.isPresent()) {
			throw new NotFoundException("Not found order with ID = " + id);
		}
		return o.get();
	}

	@Override
	public void deleteById(Long id) {
		OrderEntity foundedO = findById(id);
		foundedO.setStatus(0);
		save(foundedO);
	}

}
