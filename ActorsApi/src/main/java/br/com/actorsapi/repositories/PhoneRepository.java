package br.com.actorsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.actorsapi.models.PhoneModel;

public interface PhoneRepository extends JpaRepository<PhoneModel, Long>{

}