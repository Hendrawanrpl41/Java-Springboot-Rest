package com.sti.bootcamp.dao;

import java.util.List;

public interface TransactionDao {

	Transaction getById(int id)throws Exception;
	Transaction save(Transaction transaction)throws Exception;
	void delete(Transaction transaction)throws Exception;
	
	List<Transaction> getList() throws Exception;
}
