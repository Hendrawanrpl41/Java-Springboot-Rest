package com.sti.bootcamp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer>{
//	Customer findByCustomerNumber(int customerNumber);
}
