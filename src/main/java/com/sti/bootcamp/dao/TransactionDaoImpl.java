package com.sti.bootcamp.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionDaoImpl extends BaseImpl implements TransactionDao {
	@Autowired
	private TransactionDao repository;
	
	@Override
	public Transaction getById(int id) throws Exception {
		
		return repository.getById(id) ;
	}

	@Override
	public Transaction save(Transaction transaction) throws Exception {
		
		return repository.save(transaction);
	}

	@Override
	public void delete(Transaction transaction) throws Exception {
		repository.delete(transaction);
		
		
	}

	@Override
	public List<Transaction> getList() throws Exception {
		CriteriaBuilder CrltB = em.getCriteriaBuilder();
		CriteriaQuery<Transaction> query =CrltB.createQuery(Transaction.class);
		Root<Transaction> root = query.from(Transaction.class);
		query.select(root);
		TypedQuery<Transaction> q = em.createQuery(query);
		// TODO Auto-generated method stub
		return q.getResultList();
	}
	

}
