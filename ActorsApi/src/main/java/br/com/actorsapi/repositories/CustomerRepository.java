package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.CustomerModel;

public interface CustomerRepository  extends JpaRepository<CustomerModel, Long>{
	
	
}
