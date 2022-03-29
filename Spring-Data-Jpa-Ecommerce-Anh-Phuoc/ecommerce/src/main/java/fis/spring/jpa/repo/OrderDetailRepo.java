package fis.spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fis.spring.jpa.entity.OrderDetailEntity;

public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity, Long> {

}
