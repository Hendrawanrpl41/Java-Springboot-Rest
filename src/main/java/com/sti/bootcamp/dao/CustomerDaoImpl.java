package com.sti.bootcamp.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class CustomerDaoImpl extends BaseImpl implements CustomerDao  {

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Customer getById(int id) throws Exception {
		// TODO Auto-generated method stub

		return repository.findOne(Integer.valueOf(id));
		
	}

	@Override
	public Customer save(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public void delete(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		repository.delete(customer);
		
	}

	@Override
	public List<Customer> getList() throws Exception {
		CriteriaBuilder CrltB = em.getCriteriaBuilder();
		CriteriaQuery<Customer> query =CrltB.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
		query.select(root);
		TypedQuery<Customer> q = em.createQuery(query);
		// TODO Auto-generated method stub
		return q.getResultList();
	}
//	@Override
//	protected void configure (HttpSecurity http) throws Exception {
//	    http.csrf().disable();
//	}

}
