package fis.training.demojdbc.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMoneyForm {
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;
}
