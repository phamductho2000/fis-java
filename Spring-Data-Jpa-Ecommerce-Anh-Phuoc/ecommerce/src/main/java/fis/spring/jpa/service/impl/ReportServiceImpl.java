package fis.spring.jpa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.spring.jpa.dto.ReportByCateDTO;
import fis.spring.jpa.entity.OrderDetailEntity;
import fis.spring.jpa.entity.OrderEntity;
import fis.spring.jpa.repo.OrderDetailRepo;
import fis.spring.jpa.repo.OrderRepo;
import fis.spring.jpa.service.ReportSevice;

@Service
public class ReportServiceImpl implements ReportSevice {

	@Autowired
	OrderDetailRepo orderDetailRepo;

	@Override
	public List<ReportByCateDTO> reportByCategory() {
//		List<ReportByCateDTO> reportByCate = new ArrayList<>();
//		List<OrderEntity> orders = orderRepo.findAll();
//		for (OrderEntity order : orders) {
//			List<OrderDetailEntity> orderDetails = order.getOrderDetail();
//			for(OrderDetailEntity orderDetail : orderDetails) {
//				if(orderDetail.getProduct().getCategory() != null) {
//					reportByCate.add(new ReportByCateDTO(orderDetail.getProduct().getCategory().getName(),
//															order.getTotal()));
//				}
//			}
//		}
//		
//		Set<ReportByCateDTO> sumTotalByCate = new HashSet<>();
//		for (ReportByCateDTO report : reportByCate) {
//			if(!sumTotalByCate.add(report)) {
//				
//			}
//		}
		return orderDetailRepo.reportByCategory();
	}

}
