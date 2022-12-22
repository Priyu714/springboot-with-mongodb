package com.bank.customer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.customer.model.Account;
import com.bank.customer.model.Customer;
import com.bank.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Value("${account_save}")
	private String account_summary;
	
	public Customer saveCustomer(Customer customer) {
		Customer cus=customerRepository.save(customer);
		Account account=new Account();
		account.setAccount(customer.getAccount());
		account.setBalance(50000);
		account.setAccType("save");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:MM:ss");
	    String requiredDate = df.format(new Date());
		account.setDate(requiredDate);
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<Account> entity=new HttpEntity<Account>(account,headers);
		restTemplate.exchange(account_summary, HttpMethod.POST,entity,Account.class);
		return customer;
	}
	
	public List<Customer> allCustomer(){
		List<Customer> customerList=customerRepository.findAll();
		return customerList;
		
	}

	public String deleteById(String id) {
		customerRepository.deleteById(id);
		return "customer deleted successFully";
	}

	public Customer updateCustomer(String id, Customer customer) {
       Optional<Customer> customerupdate=customerRepository.findById(id);
        Customer cust=customerupdate.get();
        cust.setEmail(customer.getEmail());
        cust.setFname(customer.getFname());
        cust.setLname(customer.getLname());
        cust.setMobile(customer.getMobile());
        customerRepository.save(cust);
        return cust;
	}
	
	public Customer findCustomer(String account) {
	   Optional<Customer> cus=customerRepository.getAccountById(account);
		return cus.get();
	}

}
