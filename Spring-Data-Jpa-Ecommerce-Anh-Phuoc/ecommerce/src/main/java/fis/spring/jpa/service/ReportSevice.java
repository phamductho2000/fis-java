package fis.spring.jpa.service;

import java.util.List;

import fis.spring.jpa.dto.ReportByCateDTO;

public interface ReportSevice {
	List<ReportByCateDTO> reportByCategory();
}
