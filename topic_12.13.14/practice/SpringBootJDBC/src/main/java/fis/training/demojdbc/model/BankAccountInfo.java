package fis.training.demojdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountInfo {
	private Long id;
    private String fullName;
    private double balance;
}
