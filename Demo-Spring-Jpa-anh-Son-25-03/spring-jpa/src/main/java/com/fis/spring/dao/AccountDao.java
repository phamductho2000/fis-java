package com.fis.spring.dao;

import java.util.List;

import com.fis.spring.entity.Account;

public interface AccountDao {
	List<Account> getByFullname(String fullname);
}
