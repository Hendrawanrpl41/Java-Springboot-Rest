package com.sti.bootcamp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sti.bootcamp.model.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer>{
	
}
