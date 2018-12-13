package com.sti.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.TransactionDao;
import com.sti.bootcamp.model.Transaction;

@RestController
@RequestMapping("/trx")
public class TransactionController {

	@Autowired
	private TransactionDao transactionDao;
	
	//input
	@PostMapping("/transaction")
	public Transaction input (@RequestBody Transaction transaction )throws Exception {
		transactionDao.save(transaction);
		return transaction;
	}
	
	//delete
	@DeleteMapping("/transaction")
	public Transaction delete(@RequestBody Transaction transaction)throws Exception {
		transactionDao.delete(transaction);
		return transaction;
		
	}
	
	//cari data
	@GetMapping("/transaction")
	public int dao(@RequestParam(value = "id",defaultValue = "")String id)throws Exception {
		try {
			Transaction transaction = transactionDao.getById(Integer.valueOf(id));
			if (transaction==null) {
				return 0;
			} else {
				return transaction.getAmount();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return 00;
		}
	}
	//list
	@GetMapping("/transaction/data")
	public List<Transaction> allData(){
		try {
			List<Transaction> list = transactionDao.getList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
