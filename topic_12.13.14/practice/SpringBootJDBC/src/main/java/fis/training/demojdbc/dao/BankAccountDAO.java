package fis.training.demojdbc.dao;

import java.util.List;

import fis.training.demojdbc.exception.BankTransactionException;
import fis.training.demojdbc.model.BankAccountInfo;

public interface BankAccountDAO {
	List<BankAccountInfo> findAll();

	BankAccountInfo findById(Long id);
	
	void save(BankAccountInfo bankAccountInfo) throws BankTransactionException;
	
	void update(BankAccountInfo bankAccountInfo);
	
	void deleteById(Long id) throws BankTransactionException;

	void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException;
}
