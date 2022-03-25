package com.fis.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fis.spring.dao.AccountDao;
import com.fis.spring.entity.Account;

public class AccountDaoImpl implements AccountDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Account> getByFullname(String fullname) {
		String sql = "SELECT * FROM account WHERE fullname = :fullname";
		Map params = new HashMap();
		params.put("fullname", fullname);
		return namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Account.class));
	}

}
