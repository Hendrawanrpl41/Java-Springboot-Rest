package com.sti.bootcamp.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoSpringConfig {

	@Bean
	public CustomerDao customerDao() {
		return new CustomerDaoImpl();
	}
	@Bean
	public AccountDao accountDao() {
		return new AccountDaoImpl();
	}
	@Bean
	public TransactionDao transactionDao() {
		return new TransactionDaoImpl();
	}
}
