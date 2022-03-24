package fis.training.demojdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fis.training.demojdbc.exception.BankTransactionException;
import fis.training.demojdbc.mapper.BankAccountMapper;
import fis.training.demojdbc.model.BankAccountInfo;

@Repository
public class BankAccountDaoImpl extends JdbcDaoSupport implements BankAccountDAO {

	@Autowired
	public BankAccountDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<BankAccountInfo> findAll() {
		// Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
		String sql = BankAccountMapper.BASE_SQL;

		BankAccountMapper mapper = new BankAccountMapper();
		List<BankAccountInfo> list = this.getJdbcTemplate().query(sql, mapper);

		return list;
	}

	@Override
	public void save(BankAccountInfo bankAccountInfo) throws BankTransactionException {
		if (findById(bankAccountInfo.getId()) != null) {
			throw new BankTransactionException("Id with " + bankAccountInfo.getId() +" is exist");
		}
		String sql = "INSERT INTO BANK_ACCOUNT VALUES(?, ?, ?)";
		Object[] params = new Object[] { bankAccountInfo.getId(), bankAccountInfo.getFullName(),
				bankAccountInfo.getBalance() };
		this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public void update(BankAccountInfo bankAccountInfo) {
		String sql = "UPDATE BANK_ACCOUNT SET FULL_NAME = ? BALANCE = ? WHERE ID = ?";
		Object[] params = new Object[] { bankAccountInfo.getFullName(), bankAccountInfo.getBalance(),
				bankAccountInfo.getId() };
		this.getJdbcTemplate().update(sql, params);
	}

	@Override
	public void deleteById(Long id) throws BankTransactionException {
		if (findById(id) == null) {
			throw new BankTransactionException("Cannot delete with id = " + id);
		}
		String sql = "DELETE FROM BANK_ACCOUNT WHERE ID = ?";
		this.getJdbcTemplate().update(sql, id);
	}

	public BankAccountInfo findById(Long id) {
		// Select ba.Id, ba.Full_Name, ba.Balance From Bank_Account ba
		// Where ba.Id = ?
		String sql = BankAccountMapper.BASE_SQL + " WHERE ba.ID = ? ";

		BankAccountMapper mapper = new BankAccountMapper();
		try {
			BankAccountInfo bankAccount = this.getJdbcTemplate().queryForObject(sql, mapper, id);
			return bankAccount;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// MANDATORY: Giao dịch bắt buộc phải được tạo sẵn trước đó.
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(Long id, double amount) throws BankTransactionException {
		BankAccountInfo accountInfo = this.findById(id);
		if (accountInfo == null) {
			throw new BankTransactionException("Account not found " + id);
		}
		double newBalance = accountInfo.getBalance() + amount;
		if (accountInfo.getBalance() + amount < 0) {
			throw new BankTransactionException(
					"The money in the account '" + id + "' is not enough (" + accountInfo.getBalance() + ")");
		}
		accountInfo.setBalance(newBalance);
		// Update to DB
		String sqlUpdate = "Update Bank_Account set Balance = ? where Id = ?";
		this.getJdbcTemplate().update(sqlUpdate, accountInfo.getBalance(), accountInfo.getId());
	}

	@Override
	// Không được bắt BankTransactionException trong phương thức này.
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankTransactionException.class)
	public void sendMoney(Long fromAccountId, Long toAccountId, double amount) throws BankTransactionException {

		addAmount(toAccountId, amount);
		addAmount(fromAccountId, -amount);
	}

}
