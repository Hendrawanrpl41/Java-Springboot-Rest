package com.sti.bootcamp.dao;

import java.util.List;

public interface CustomerDao {

	Customer getById(int id)throws Exception;
	Customer save(Customer customer)throws Exception;
	void delete(Customer customer)throws Exception;
	
	List<Customer> getList() throws Exception;
	
}
