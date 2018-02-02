package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.CompanyModel;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long>{

}
