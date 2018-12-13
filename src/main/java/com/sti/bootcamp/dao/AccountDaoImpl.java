package com.sti.bootcamp.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountDaoImpl extends BaseImpl implements AccountDao {

	@Autowired
	private AccountRepository repository;
	
	@Override
	public Account getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return repository.findOne(Integer.valueOf(id));
	}

	@Override
	public Account save(Account account) throws Exception {
		// TODO Auto-generated method stub
		return repository.save(account);
	}

	@Override
	public void delete(Account account) throws Exception {
		// TODO Auto-generated method stub
		repository.delete(account);
	}

	@Override
	public List<Account> getList() throws Exception {
		// TODO Auto-generated method stub
		CriteriaBuilder CrltB = em.getCriteriaBuilder();
		CriteriaQuery<Account> query =CrltB.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		query.select(root);
		TypedQuery<Account> q = em.createQuery(query);
		// TODO Auto-generated method stub
		return q.getResultList();
	}

}
