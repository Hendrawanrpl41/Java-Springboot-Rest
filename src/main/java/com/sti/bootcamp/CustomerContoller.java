package com.sti.bootcamp;

import java.util.List;

import javax.xml.ws.BindingType;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.Customer;
import com.sti.bootcamp.dao.CustomerDao;
import com.sti.bootcamp.dao.CustomerRepository;
@Controller
@RestController
@RequestMapping("/cus")
public class CustomerContoller {
	@Autowired
	private CustomerDao customerDao;

	
	
	
	//input
	@PostMapping("/customer")
	public Customer inputCustomer (@RequestBody Customer customer )throws Exception {
		customerDao.save(customer);
		return customer;
	}
	
	//delete
	@DeleteMapping("/customer")
	public Customer deleteCustomer(@RequestBody Customer customer)throws Exception {
		customerDao.delete(customer);
		return customer;
		
	}
	
	//cari data
	@GetMapping("/customer")
	public String dao(@RequestParam(value = "id",defaultValue = "")String id)throws Exception {
		try {
			Customer customer = customerDao.getById(Integer.valueOf(id));
			if (customer==null) {
				return "Data tidak ditemukan";
			} else {
				return customer.getFirstName();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return "salah format input";
		}catch (Exception e) {
			// TODO: handle exception
			return String.format("terjadi kesalahan sistem : ", e.getMessage());
		}
	}
	//list
	@GetMapping("/customer/data")
	public List<Customer> allData(){
		try {
			List<Customer> list = customerDao.getList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
//	@GetMapping("/customer/{id}")
//	public Customer getById(@PathVariable int id) {
//		Customer customer = new Customer();
//		customer.setCustomerNumber(id);
//		return customer;
//	}

//	@PostMapping("/addcustomer")
//	public Customer addcustomer(@RequestBody Customer customer) {
//		
//		return customer;
//	}
//
//	@GetMapping("/test")
//	public String coba(@RequestParam(value="nama",required=false) String nama) {
//		
//		return nama;
//	}
//	
	
//	@GetMapping("/readcustomer")
//	public Customer readcustomer() {
//		Customer customer = new Customer();
//		return customer;
//	}
	
//	@PutMapping("/updatecustomer")
//	public Customer updatecustomer(@RequestBody Customer customer) {
//		return customer;
//	}
	
//	@PostMapping("/customer")
//	public Customer nama(@RequestParam("nama") String nama) {
//		Customer customer = new Customer();
//		customer.setUsername(nama);
//		return customer;
//	}
	
	
//	@DeleteMapping("/customer/{id}")
//	public String delete(@PathVariable String id) {
//		String hasil = id;
//		return hasil;
//	}
	
//	@GetMapping("/customer")
//	public Customer getlist(@RequestBody Customer customer){
////		Customer custo = new Customer();
////		ArrayList<Customer> list = new ArrayList<>();
////		
////		list.add(customer);
//		return customer;
//	}
}
