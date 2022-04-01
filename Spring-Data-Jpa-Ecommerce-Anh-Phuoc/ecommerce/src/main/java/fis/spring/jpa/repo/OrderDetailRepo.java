package fis.spring.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fis.spring.jpa.dto.ReportByCateDTO;
import fis.spring.jpa.entity.OrderDetailEntity;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity, Long> {
	@Query("SELECT NEW fis.spring.jpa.dto.ReportByCateDTO(c.name, sum(ode.total)) "
			+ "FROM OrderDetailEntity ode "
			+ "JOIN ode.product p "
			+ "JOIN p.category c "
			+ "GROUP BY c.name ")
	List<ReportByCateDTO> reportByCategory();
}
