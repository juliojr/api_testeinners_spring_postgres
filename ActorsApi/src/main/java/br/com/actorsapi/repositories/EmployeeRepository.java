package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
