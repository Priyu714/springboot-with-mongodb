package com.bank.customer.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.model.Customer;
import com.bank.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> allCustomer() {
		List<Customer> customerList = customerServiceImpl.allCustomer();
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}
	
	@GetMapping("/{account}")
	public ResponseEntity<Customer> findCustomer(@PathVariable String account) {
		Customer customer = customerServiceImpl.findCustomer(account);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	

	

	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		// table
		Customer customer1 = customerServiceImpl.saveCustomer(customer);
		
		// rest template->account
		return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id) {
		String message = customerServiceImpl.deleteById(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String id,@RequestBody Customer customer){
		Customer cust=customerServiceImpl.updateCustomer(id,customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	
}
