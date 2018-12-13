package com.sti.bootcamp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.Account;
import com.sti.bootcamp.dao.AccountDao;


@RestController
@RequestMapping("/acc")
public class AccountController {

	@Autowired
	private AccountDao accountDao;
	
	//input
	@PostMapping("/account")
	public Account input (@RequestBody Account account )throws Exception {
		accountDao.save(account);
		return account;
	}
	
	//delete
	@DeleteMapping("/account")
	public Account delete(@RequestBody Account account)throws Exception {
		accountDao.delete(account);
		return account;
		
	}
	
	//cari data
	@GetMapping("/account")
	public int dao(@RequestParam(value = "id",defaultValue = "")String id)throws Exception {
		try {
			Account account = accountDao.getById(Integer.valueOf(id));
			if (account==null) {
				return 0;
			} else {
				return account.getBalance();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return 00;
		}
	}
	//list
	@GetMapping("/account/data")
	public List<Account> allData(){
		try {
			List<Account> list = accountDao.getList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
