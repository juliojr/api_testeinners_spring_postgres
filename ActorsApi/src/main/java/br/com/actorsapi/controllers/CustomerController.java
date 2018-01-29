package br.com.actorsapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.actorsapi.models.CustomerModel;
import br.com.actorsapi.repositories.AddressRepository;
import br.com.actorsapi.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping
	public List<CustomerModel> getAllCustomers() {
		List<CustomerModel> customers = (List<CustomerModel>) customerRepository.findAll(); 
		return customers;
	}

	@PostMapping
	public CustomerModel createCustomer(@Valid @RequestBody CustomerModel customer) {
		customer = customerRepository.save(customer);
		return customer;
	}
}
