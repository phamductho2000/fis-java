package com.fis.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.spring.dao.AccountDao;
import com.fis.spring.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>, AccountDao {

}
