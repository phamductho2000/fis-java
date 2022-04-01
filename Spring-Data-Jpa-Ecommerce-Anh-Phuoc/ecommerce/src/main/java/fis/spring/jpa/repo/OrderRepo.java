package fis.spring.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fis.spring.jpa.dto.ReportByCateDTO;
import fis.spring.jpa.entity.OrderEntity;

@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Long> {

	
}
