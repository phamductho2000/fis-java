package fis.spring.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReportByCateDTO {

	private String cateName;
	
	private Double total;
	
}
