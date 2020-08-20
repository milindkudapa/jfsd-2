package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@GetMapping("/customers")
	public ResponseEntity<Iterable<Customer>> getAllCustomer()
	{
		return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("customerId") String customerId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.findCustomerById(customerId));
	}
	

}
